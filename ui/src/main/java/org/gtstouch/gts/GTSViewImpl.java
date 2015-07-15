package org.gtstouch.gts;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.vaadin.cdiviewmenu.ViewMenuItem;

import com.vaadin.cdi.CDIView;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitHandler;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.FieldEvents;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import java.util.Collection;
import org.gtstouch.app.AbstractView;
import org.gtstouch.model.Account;

import org.vaadin.viritin.layouts.MVerticalLayout;

@CDIView(GTSView.ID)
@ViewMenuItem(title = "GTS Account")
public class GTSViewImpl extends AbstractView<GTSViewPresenter> implements
        GTSView {

    @Inject
    private Instance<GTSViewPresenter> presenterInstance;

    private AccountGrid grid;
    private Button bnewAccount;
    BeanFieldGroup<Account> bfg = new BeanFieldGroup<>(Account.class);

    public GTSViewImpl() {

        HorizontalLayout topLayout = createTopBar();
        grid = new AccountGrid();
        grid.setEditorEnabled(true);

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
                presenterInstance.get().editAccount(rez.getBean());

            }

        });

        setGridFieldGroup(bfg);
        setCompositionRoot(new MVerticalLayout(topLayout, grid));
    }

    @Override
    protected GTSViewPresenter generatePresenter() {
        return presenterInstance.get();
    }

    @Override
    public void setMessage(String message) {

    }

    public HorizontalLayout createTopBar() {
        TextField filter = new TextField();
        filter.setStyleName("filter-textfield");
        filter.setInputPrompt("Filter");
        // ResetButtonForTextField.extend(filter);
        filter.setImmediate(true);
        filter.addTextChangeListener(new FieldEvents.TextChangeListener() {
            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {
                grid.setFilter(event.getText());
            }
        });

        bnewAccount = new Button("New Account");
        bnewAccount.addStyleName(ValoTheme.BUTTON_PRIMARY);
        bnewAccount.setIcon(FontAwesome.PLUS_CIRCLE);
        bnewAccount.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                newAccount();
            }
        });

        HorizontalLayout topLayout = new HorizontalLayout();
        topLayout.setSpacing(true);
        topLayout.setWidth("100%");
        topLayout.addComponent(filter);
        topLayout.addComponent(bnewAccount);
        topLayout.setComponentAlignment(filter, Alignment.MIDDLE_LEFT);
        topLayout.setExpandRatio(filter, 1);
        topLayout.setStyleName("top-bar");
        return topLayout;
    }

    public void showAccounts(Collection<Account> accounts) {
        grid.setAccounts(accounts);
    }

    @Override
    public void newAccount() {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Account account = new Account();
        grid.refresh(account);

    }

    @Override
    public void setGridFieldGroup(BeanFieldGroup<Account> bfg) {
        grid.setEditorFieldGroup(bfg);
    }
}
