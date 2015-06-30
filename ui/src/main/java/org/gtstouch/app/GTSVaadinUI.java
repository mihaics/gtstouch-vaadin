package org.gtstouch.app;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;
import java.util.Date;

import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.inject.Inject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.gtstouch.jpa.UserService;
import org.gtstouch.login.LoginView;
import org.gtstouch.login.UserLoggedInEvent;
import org.gtstouch.map.GTSMapView;
import org.gtstouch.model.UserPK;
import org.vaadin.cdiviewmenu.ViewMenuUI;

@CDIUI("")
@Theme("valo")
public class GTSVaadinUI extends ViewMenuUI {

    @Inject
    UserService userService;

    private Button logout;
    private UserPK userIndex;

    private final Button.ClickListener logoutClickListener = new Button.ClickListener() {
        private static final long serialVersionUID = -1545988729141348821L;

        @Override
        public void buttonClick(ClickEvent event) {
            SecurityUtils.getSubject().logout();
            VaadinSession.getCurrent().close();
            Page.getCurrent().setLocation("");
        }
    };

    @Override
    protected void init(VaadinRequest request) {
        super.init(request);

        logout = new Button("Logout", logoutClickListener);
        logout.setIcon(FontAwesome.SIGN_OUT);

        if (!isLoggedIn()) {
            ViewMenuUI.getMenu().setVisible(false);
            ViewMenuUI.getMenu().navigateTo(LoginView.ID);
        } else {
            if (getNavigator().getState().isEmpty()) {
                ViewMenuUI.getMenu().navigateTo(GTSMapView.ID);
                getMenu().addMenuItem(logout);
                getMenu().setVisible(true);
            }
        }
    }

    private boolean isLoggedIn() {
        Subject subject = SecurityUtils.getSubject();
        if (subject == null) {
            System.err.println("Could not find subject");
            return false;
        }

        return subject.isAuthenticated();
    }

    public void userLoggedIn(
            @Observes(notifyObserver = Reception.IF_EXISTS) UserLoggedInEvent event) {
        Subject subject = SecurityUtils.getSubject();
        //boolean rez = subject.hasRole("test");
        Notification.show("Welcome back " + event.getUsername() + " / " + subject.getPrincipal().toString() + " / admin: " + subject.hasRole("admin"), Notification.Type.HUMANIZED_MESSAGE);
        updateLoginTime(subject);
        getUserData(subject);
        getMenu().navigateTo(GTSMapView.ID);
        getMenu().addMenuItem(logout);
        getMenu().setVisible(isLoggedIn());
    }

    private void updateLoginTime(Subject subject) {
        String contactEmail = (String) subject.getPrincipal();
        Date time = new Date();
        int rez = userService.updateLoginTime(contactEmail, time.getTime());
        //Notification.show("Updated: " + contactEmail + " at " + time + " rezult: " + rez);

    }

    public static GTSVaadinUI getApp() {
        return (GTSVaadinUI) GTSVaadinUI.getCurrent();
    }

    public String getUserID() {
        return userIndex.getUserID();
    }

    public String getAccountID() {

        return userIndex.getAccountID();
    }

    public UserPK getUserIndex() {
        return userIndex;
    }

    public void setUserIndex(UserPK userIndex) {
        this.userIndex = userIndex;
    }

    private void getUserData(Subject subject) {
        String contactEmail = (String) subject.getPrincipal();
        userIndex = userService.getUserIndex(contactEmail);
    }

}
