package org.gtstouch.gts;

import java.util.Date;

import com.vaadin.cdi.UIScoped;
import javax.inject.Inject;
import org.gtstouch.app.AbstractPresenter;
import org.gtstouch.jpa.AccountService;
import org.gtstouch.jpa.JPATest;

/**
 *
 * @author mihai
 */
@UIScoped
public class GTSViewPresenter extends AbstractPresenter<GTSView> {

    @Inject
    AccountService as;

    @Override
    protected void onViewEnter() {

    }

    public void doSomething() {
        JPATest test = new JPATest();

        int rez = as.getEntityCount();

        getView().setMessage("We did something at " + new Date() + " / " + rez);

    }

}
