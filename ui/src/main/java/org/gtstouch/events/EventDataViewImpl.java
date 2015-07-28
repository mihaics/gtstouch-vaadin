package org.gtstouch.events;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.vaadin.cdiviewmenu.ViewMenuItem;

import com.vaadin.cdi.CDIView;
import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitHandler;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.converter.Converter;
import com.vaadin.event.FieldEvents;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import java.util.Collection;
import java.util.Date;
import org.gtstouch.app.AbstractView;

import org.gtstouch.model.EventData;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.layouts.MHorizontalLayout;

import org.vaadin.viritin.layouts.MVerticalLayout;

@CDIView(EventDataView.ID)
@ViewMenuItem(title = "EventData")
public class EventDataViewImpl extends AbstractView<EventDataViewPresenter> implements
        EventDataView {

    @Inject
    private Instance<EventDataViewPresenter> presenterInstance;

    private EventDataGrid grid;

    PopupDateField start = new PopupDateField("From");
    PopupDateField end = new PopupDateField("To");

    static final long DAY = 24 * 60 * 60 * 1000;
    static final long ONE_WEEK = 7 * DAY;
    static final long ONE_HOUR = 60 * 60 * 1000;

    static final Date periodEnd = new Date();
    static final Date periodStart = new Date(2014, 1, 1);

    BeanFieldGroup<EventData> bfg = new BeanFieldGroup<>(EventData.class);

    public EventDataViewImpl() {

        HorizontalLayout topLayout = createTopBar();
        grid = new EventDataGrid();
        grid.setEditorEnabled(false);

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
                BeanItem<EventData> rez = (BeanItem<EventData>) commitEvent.getFieldBinder().getItemDataSource();

                //  Logger.getLogger("GTSViewPresenter").log(Level.INFO,"Postcommit: "+rez.toString()); //To change body of generated methods, choose Tools | Templates.
                // presenterInstance.get().editAccount(rez.getBean());
            }

        });

        setGridFieldGroup(bfg);
        setCompositionRoot(new MVerticalLayout(topLayout, grid));
    }

    @Override
    protected EventDataViewPresenter generatePresenter() {
        return presenterInstance.get();
    }

    @Override
    public void setMessage(String message) {

    }

    public MHorizontalLayout createTopBar() {
        prepareDateRangeSelector();
        MTextField filter = new MTextField("Filter");
       // filter.setStyleName("filter-textfield");
        filter.setInputPrompt("Filter");
        // ResetButtonForTextField.extend(filter);
        filter.setImmediate(true);
        filter.addTextChangeListener(new FieldEvents.TextChangeListener() {
            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {
                grid.setFilter(event.getText());
            }
        });

        MHorizontalLayout topLayout = new MHorizontalLayout();
       // topLayout.setSpacing(true);
       // topLayout.setWidth("100%");
        
        topLayout.add(filter, start, end ).withFullWidth().withAlign(filter, Alignment.MIDDLE_LEFT);
       // topLayout.addComponent(start);
       // topLayout.addComponent(end);
        //topLayout.setComponentAlignment(filter, Alignment.MIDDLE_LEFT);
       // topLayout.setExpandRatio(filter, 1);
       // topLayout.setStyleName("top-bar");
        return topLayout;
    }

    public void showEventData(Collection<EventData> events) {
        grid.setEventData(events);
    }

    public void setGridFieldGroup(BeanFieldGroup<EventData> bfg) {
        grid.setEditorFieldGroup(bfg);
    }

    @Override
    public void showGPSEvents(Collection<EventData> events) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        grid.setEventData(events);
    }

    @Override
    public void newGPSEvent() {

        EventData event = new EventData();
        grid.refresh(event);
    }

    protected void prepareDateRangeSelector() throws Property.ReadOnlyException, Converter.ConversionException {
        start.setResolution(Resolution.MINUTE);
        end.setResolution(Resolution.MINUTE);
        /*
         * set data range for component validation
         */
        // start.setRangeStart(periodStart);
        start.setRangeEnd(periodEnd);
        //  end.setRangeStart(periodStart);
        end.setRangeEnd(periodEnd);

        //default to last day
        start.setValue(new Date(periodEnd.getTime() - DAY));
        end.setValue(new Date());

        start.addValueChangeListener(e -> {
            long maxEnd = start.getValue().getTime() + ONE_WEEK;
            if (end.getValue().getTime() > maxEnd) {
                end.setValue(new Date(maxEnd));
            } else if (end.getValue().getTime() < start.getValue().getTime()) {
                end.setValue(new Date(start.getValue().getTime() + DAY));
            }
            // drawRoute();
        });
        end.addValueChangeListener(e -> {
            long minStart = end.getValue().getTime() - ONE_WEEK;
            if (start.getValue().getTime() < minStart) {
                start.setValue(new Date(minStart));
            } else if (start.getValue().getTime() > end.getValue().getTime()) {
                start.setValue(new Date(end.getValue().getTime() - DAY));
            }
            // drawRoute();
        });
    }
}
