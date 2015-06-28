package org.gtstouch.login;

import org.gtstouch.app.ApplicationView;



public interface LoginView extends ApplicationView<LoginViewPresenter> {

    public static final String ID = "";

    void showInvalidLoginNotification();

}
