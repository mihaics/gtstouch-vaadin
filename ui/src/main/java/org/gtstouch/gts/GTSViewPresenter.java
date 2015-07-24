package org.gtstouch.gts;

import com.vaadin.cdi.UIScoped;
import javax.inject.Inject;
import org.gtstouch.app.AbstractPresenter;
import org.gtstouch.model.Account;
import org.gtstouch.service.AccountFacade;
import org.gtstouch.service.UserFacade;

/**
 *
 * @author mihai
 */
@UIScoped
public class GTSViewPresenter extends AbstractPresenter<GTSView> {

    @Inject
    AccountFacade af;
    //AccountService as;
    @Inject
    UserFacade uf;

    @Override
    protected void onViewEnter() {
        //this should be done outside view enter, only once
        getView().showAccounts(af.findAll());
    }

    public void editAccount(Account accountBean) {
        af.edit(accountBean);
    }
}
