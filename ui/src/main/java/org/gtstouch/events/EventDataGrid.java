/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gtstouch.events;

import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.MethodProperty;
import com.vaadin.data.util.filter.Or;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.ui.Grid;
import java.util.Collection;
import org.gtstouch.model.EventData;

/**
 *
 * @author mihai
 */
public class EventDataGrid extends Grid {

    public EventDataGrid() {

        setSizeFull();
        setSelectionMode(SelectionMode.SINGLE);
        BeanItemContainer<EventData> container = new BeanItemContainer<>(EventData.class);
        setContainerDataSource(container);
        setColumns("eventDataPK", "address", "speedKPH", "odometerKM",
                "distanceKM", "latitude", "longitude");

        setColumnReorderingAllowed(true);
        setFrozenColumnCount(1);

    }

    private BeanItemContainer<EventData> getContainer() {
        return (BeanItemContainer<EventData>) super.getContainerDataSource();
    }

    @Override
    public EventData getSelectedRow() throws IllegalStateException {
        return (EventData) super.getSelectedRow();
    }

    public void setAccounts(Collection<EventData> events) {
        getContainer().removeAllItems();
        getContainer().addAll(events);
    }

    public void remove(EventData event) {
        getContainer().removeItem(event);
    }

    public void refresh(EventData event) {
        // We avoid updating the whole table through the backend here so we can
        // get a partial update for the grid
        BeanItem<EventData> item = getContainer().getItem(event);
        if (item != null) {
            // Updated product
            MethodProperty ac = (MethodProperty) item.getItemProperty("deviceID");
            ac.fireValueChange();
        } else {
            // New account
            getContainer().addBean(event);
            editItem(event);
        }
    }

    void setFilter(String filterString) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        getContainer().removeAllContainerFilters();
        if (filterString.length() > 0) {
            SimpleStringFilter nameFilter = new SimpleStringFilter(
                    "address", filterString, true, false);
            SimpleStringFilter availabilityFilter = new SimpleStringFilter(
                    "deviceID", filterString, true, false);
            getContainer().addContainerFilter(
                    new Or(nameFilter, availabilityFilter));
        }
    }

    void setEventData(Collection<EventData> events) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
