package org.gtstouch.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.util.JdbcUtils;

public class GtsRealm extends JdbcRealm {

    /**
     * caută accountID pentru utilizator apoi verifică dacă contul este activ
     * sau există (necesar datorită designului OPenGTS, pot exista useri fără
     * cont)
     */
    protected String getAccountQuery;
    protected String validAccountQuery;

    static final Logger log = Logger.getLogger(GtsRealm.class.getName());

    /**
     * jndiDataSourceName
     */
    protected String jndiDataSourceName;

    public GtsRealm() {

        super();
        this.validAccountQuery = "select Account.isActive from Account where accountID = ?";
        this.getAccountQuery = "select User.accountID from User where User.contactEmail = ?";

    }

    public String getJndiDataSourceName() {
        return jndiDataSourceName;
    }

    public void setJndiDataSourceName(String jndiDataSourceName) {
        this.jndiDataSourceName = jndiDataSourceName;
        this.dataSource = getDataSourceFromJNDI(jndiDataSourceName);
    }

    private DataSource getDataSourceFromJNDI(String jndiDataSourceName) {
        try {
            InitialContext ic = new InitialContext();
            return (DataSource) ic.lookup(jndiDataSourceName);
        } catch (NamingException e) {
            log.log(Level.INFO, "JNDI error while retrieving {0} : {1}", new Object[]{jndiDataSourceName, e.getExplanation()});

            throw new AuthorizationException(e);
        }
    }

    /**
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        //char[] pw = upToken.getPassword();
        //log.log(Level.INFO, "Token password: {0}", Arrays.toString(pw));

        // Null username is invalid
        if (username == null) {
            throw new AccountException(
                    "Null usernames are not allowed by this realm.");
        }

        Connection conn = null;
        AuthenticationInfo info = null;
        try {
            conn = dataSource.getConnection();

            String password = getPasswordForUser(conn, username);
            Boolean isValidAccount = getAccountForUser(conn, username);

            if (password == null) {
                throw new UnknownAccountException("No account found for user ["
                        + username + "]");
            }
            if (!isValidAccount) {
                throw new UnknownAccountException(
                        "No valid GTS account found for user [" + username
                        + "]");
            }

            info = new SimpleAuthenticationInfo(username,
                    password.toCharArray(), getName());

        } catch (SQLException e) {
            final String message = "There was a SQL error while authenticating user ["
                    + username + "]";
            log.log(Level.INFO, "{0} : {1}", new Object[]{message, e.getMessage()});

            // Rethrow any SQL errors as an authentication exception
            throw new AuthenticationException(message, e);
        } finally {
            JdbcUtils.closeConnection(conn);
        }

        return info;
    }

    private Boolean getAccountForUser(Connection conn, String username)
            throws SQLException {
        // TODO Auto-generated method stub
        PreparedStatement ps = null;
        ResultSet rs = null;
        String accountID = null;
        String valid = null;

        try {
            ps = conn.prepareStatement(getAccountQuery);
            ps.setString(1, username);

            // Execute query
            rs = ps.executeQuery();

            // Loop over results - although we are only expecting one result,
            // since usernames should be unique
            boolean foundResult = false;
            while (rs.next()) {

                // Check to ensure only one row is processed
                if (foundResult) {

                    throw new AuthenticationException(
                            "More than one account row found for user ["
                            + username + "]. Usernames must be unique.");
                }

                accountID = rs.getString(1);

                foundResult = true;

            }
            if (accountID == null) {

                throw new UnknownAccountException(
                        "No GTS account found for user [" + username + "]");
            }
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(ps);
            // now check if the account isValid
            ps = conn.prepareStatement(validAccountQuery);
            ps.setString(1, accountID);

            rs = ps.executeQuery();
            foundResult = false;
            while (rs.next()) {

                // Check to ensure only one row is processed
                if (foundResult) {

                    throw new AuthenticationException(
                            "More than one account row found for user ["
                            + username + "]. Accounts must be unique.");
                }

                valid = rs.getString(1);

                foundResult = true;

            }
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(ps);
        }

        return valid.contains("1");
    }

    private String getPasswordForUser(Connection conn, String username)
            throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String password = null;
        try {
            ps = conn.prepareStatement(authenticationQuery);
            ps.setString(1, username);

            // Execute query
            rs = ps.executeQuery();

            // Loop over results - although we are only expecting one result,
            // since usernames should be unique
            boolean foundResult = false;
            while (rs.next()) {

                // Check to ensure only one row is processed
                if (foundResult) {

                    throw new AuthenticationException(
                            "More than one user row found for user ["
                            + username + "]. Usernames must be unique.");
                }

                password = rs.getString(1);

                foundResult = true;
            }
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(ps);
        }

        return password;
    }

    /**
     *
     * @param conn
     * @param username
     * @return
     * @throws SQLException
     */
    @Override
    protected Set getRoleNamesForUser(Connection conn, String username)
            throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Set roleNames = new LinkedHashSet();

        try {
            ps = conn.prepareStatement(userRolesQuery);
            ps.setString(1, username);
           // ps.setString(2, username);

            // Execute query
            rs = ps.executeQuery();

            // Loop over results and add each returned role to a set
            while (rs.next()) {

                String roleName = rs.getString(1);

                // Add the role to the list of names if it isn't null
                if (roleName != null) {
                    roleNames.add(roleName);
                } else {
                    // if (log.isDebugEnabled()) {
                    log.log(Level.INFO, "Null role name found while retrieving role names for user [{0}]", username);
                    // }
                }
            }
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(ps);
        }

        return roleNames;
    }

}
