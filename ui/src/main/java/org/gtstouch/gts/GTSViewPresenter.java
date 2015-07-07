package org.gtstouch.gts;

import java.util.Date;

import com.vaadin.cdi.UIScoped;
import javax.inject.Inject;
import org.gtstouch.app.AbstractPresenter;
import org.gtstouch.jpa.JPATest;
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
        getView().showAccounts(af.findAll());
    }

    public void doSomething() {
        JPATest test = new JPATest();

        int rez = af.count()+uf.count();
       // int rez = as.getEntityCount();

        getView().setMessage("We did something at " + new Date() + " / " + rez);

    }

   
}
