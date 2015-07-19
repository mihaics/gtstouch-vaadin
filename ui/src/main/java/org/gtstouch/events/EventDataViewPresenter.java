package org.gtstouch.events;


import com.vaadin.cdi.UIScoped;
import org.gtstouch.app.AbstractPresenter;

/**
 *
 * @author mihai
 */
@UIScoped
public class EventDataViewPresenter extends AbstractPresenter<EventDataView> {

    
   

    @Override
    protected void onViewEnter() {
        //this should be done outside view enter, only once
          //getView().showAccounts(af.findAll());
    }
    
     
}
