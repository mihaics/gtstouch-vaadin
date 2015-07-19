package org.gtstouch.events;

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

import org.gtstouch.model.EventData;

import org.vaadin.viritin.layouts.MVerticalLayout;

@CDIView(EventDataView.ID)
@ViewMenuItem(title = "EventData")
public class EventDataViewImpl extends AbstractView<EventDataViewPresenter> implements
        EventDataView {

    @Inject
    private Instance<EventDataViewPresenter> presenterInstance;

    private EventDataGrid grid;
    private Button bnewGPSEvent;
    BeanFieldGroup<EventData> bfg = new BeanFieldGroup<>(EventData.class);

    public EventDataViewImpl() {

        HorizontalLayout topLayout = createTopBar();
        grid = new EventDataGrid();
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

        bnewGPSEvent = new Button("New GPSEvent");
        bnewGPSEvent.addStyleName(ValoTheme.BUTTON_PRIMARY);
        bnewGPSEvent.setIcon(FontAwesome.PLUS_CIRCLE);
        bnewGPSEvent.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                newGPSEvent();
            }
        });

        HorizontalLayout topLayout = new HorizontalLayout();
        topLayout.setSpacing(true);
        topLayout.setWidth("100%");
        topLayout.addComponent(filter);
        topLayout.addComponent(bnewGPSEvent);
        topLayout.setComponentAlignment(filter, Alignment.MIDDLE_LEFT);
        topLayout.setExpandRatio(filter, 1);
        topLayout.setStyleName("top-bar");
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


   
}
