package org.gtstouch.gts;

import java.util.Collection;
import org.gtstouch.app.ApplicationView;
import org.gtstouch.model.Account;

public interface GTSView extends ApplicationView<GTSViewPresenter> {

    public static final String ID = "gtsview";

    void setMessage(String message);

    void newAccount();

    public void showAccounts(Collection<Account> accounts);

}
