package org.gtstouch.events;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import java.util.Collection;
import org.gtstouch.app.ApplicationView;
import org.gtstouch.model.EventData;

public interface EventDataView extends ApplicationView<EventDataViewPresenter> {

    public static final String ID = "eventdataview";

    void setMessage(String message);

    void newGPSEvent();

    public void showGPSEvents(Collection<EventData> events);

    public void setGridFieldGroup(BeanFieldGroup<EventData> bfg);
   
    

}
