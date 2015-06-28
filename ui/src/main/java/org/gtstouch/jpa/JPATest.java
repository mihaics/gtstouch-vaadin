package org.gtstouch.jpa;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import org.gtstouch.model.Account;

public class JPATest {

    static String PERSISTENCE_UNIT = "gtstouchPU";
    final Subject currentUser = SecurityUtils.getSubject();
    private final JPAContainer<Account> account;
 //   private final JPAContainer<User> user;
  //  private final JPAContainer<UserPK> userpk;

    //private JPAContainer<UserId>  userid;
    public JPATest() {

        account = JPAContainerFactory.make(Account.class, PERSISTENCE_UNIT);
    //    user = JPAContainerFactory.make(User.class, PERSISTENCE_UNIT);
     //   userpk = JPAContainerFactory.make(UserPK.class, PERSISTENCE_UNIT);

        Logger.getLogger(JPATest.class.getName()).log(Level.INFO, "Current user : {0}", currentUser.getPrincipal().toString());

       // Filter userfilter = new Compare.Equal("contactEmail", currentUser.getPrincipal().toString());
     //   user.addContainerFilter(userfilter);
      //  user.applyFilters();
        //here the container should contain 1 row, 1 item, check, throw exception
    //    Logger.getLogger(JPATest.class.getName()).log(Level.INFO, "User Table size : {0}", user.size());

     //   UserPK rez = (UserPK) user.firstItemId();

   //     Logger.getLogger(JPATest.class.getName()).log(Level.WARNING, "Account ID: {0}", rez.getAccountID());
     //   Logger.getLogger(JPATest.class.getName()).log(Level.WARNING, "User id: {0}", rez.getUserID());

        //String fuid = userid.firstItemId().toString();
        //Logger.getLogger(JPATest.class.getName()).log(Level.WARNING, "First item UserId: "+ fuid);
        String fid = account.firstItemId().toString();

        Logger.getLogger(JPATest.class.getName()).log(Level.INFO, "AccountID: {0}", fid);
        /*
         JPAContainer<Device> devices = JPAContainerFactory.makeReadOnly(Device.class,
         PERSISTENCE_UNIT);

         //Filter filter = new And(new SimpleStringFilter(propertyId, filterString, true, false), new SimpleStringFilter(propertyId, filterString, true, false));
         Filter filter = new Compare.Equal(DeviceFields.Id, new DevicePK("sysadmin", "at3"));
         Logger.getLogger(JPATest.class.getName()).log(Level.WARNING, "Ids size: " + devices.size());
         devices.addContainerFilter(filter);
         devices.applyFilters();
         Logger.getLogger(JPATest.class.getName()).log(Level.WARNING, "Ids filtered size: " + devices.size());
         */
    }

}
