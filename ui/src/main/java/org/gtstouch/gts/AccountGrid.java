/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gtstouch.gts;

import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.MethodProperty;
import com.vaadin.data.util.filter.Or;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.ui.Grid;
import java.util.Collection;
import org.gtstouch.model.Account;

/**
 *
 * @author mihai
 */
public class AccountGrid extends Grid {

    public AccountGrid() {

        setSizeFull();
        setSelectionMode(SelectionMode.SINGLE);
        BeanItemContainer<Account> container = new BeanItemContainer<>(Account.class);
        setContainerDataSource(container);
        setColumnOrder("accountID", "notifyEmail", "password", "contactName",
                "contactPhone", "contactEmail");
        setColumnReorderingAllowed(true);
        setFrozenColumnCount(1);

    }

    private BeanItemContainer<Account> getContainer() {
        return (BeanItemContainer<Account>) super.getContainerDataSource();
    }

    @Override
    public Account getSelectedRow() throws IllegalStateException {
        return (Account) super.getSelectedRow();
    }

    public void setAccounts(Collection<Account> accounts) {
        getContainer().removeAllItems();
        getContainer().addAll(accounts);
    }

    public void remove(Account account) {
        getContainer().removeItem(account);
    }

    public void refresh(Account account) {
        // We avoid updating the whole table through the backend here so we can
        // get a partial update for the grid
        BeanItem<Account> item = getContainer().getItem(account);
        if (item != null) {
            // Updated product
            MethodProperty ac = (MethodProperty) item.getItemProperty("accountID");
            ac.fireValueChange();
        } else {
            // New account
            getContainer().addBean(account);
            editItem(account);
        }
    }

    void setFilter(String filterString) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        getContainer().removeAllContainerFilters();
        if (filterString.length() > 0) {
            SimpleStringFilter nameFilter = new SimpleStringFilter(
                    "accountID", filterString, true, false);
            SimpleStringFilter availabilityFilter = new SimpleStringFilter(
                    "contactName", filterString, true, false);
            SimpleStringFilter categoryFilter = new SimpleStringFilter(
                    "contactEmail", filterString, true, false);
            getContainer().addContainerFilter(
                    new Or(nameFilter, availabilityFilter, categoryFilter));
        }
    }
}
