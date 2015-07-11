package org.gtstouch.gts;

import java.util.Date;

import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitHandler;
import com.vaadin.data.util.BeanItem;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    BeanFieldGroup<Account> bfg = new BeanFieldGroup<>(Account.class);

    @Override
    protected void onViewEnter() {

        bfg.addCommitHandler(new CommitHandler() {

            @Override
            public void preCommit(FieldGroup.CommitEvent commitEvent) {
                //initial item
                // Item rez = commitEvent.getFieldBinder().getItemDataSource();

                // Logger.getLogger("GTSViewPresenter").log(Level.INFO, "Precommit: "+rez.toString()); 
            }

            @Override
            public void postCommit(FieldGroup.CommitEvent commitEvent) {
                //modified item
                BeanItem<Account> rez = (BeanItem<Account>) commitEvent.getFieldBinder().getItemDataSource();

                //  Logger.getLogger("GTSViewPresenter").log(Level.INFO,"Postcommit: "+rez.toString()); //To change body of generated methods, choose Tools | Templates.
                af.edit(rez.getBean());
            }

        });
        getView().setGridFieldGroup(bfg);
        getView().showAccounts(af.findAll());
    }
}
