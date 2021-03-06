package org.gtstouch.events;

import com.vaadin.cdi.UIScoped;
import javax.inject.Inject;
import org.gtstouch.app.AbstractPresenter;
import org.gtstouch.app.GTSVaadinUI;
import org.gtstouch.service.EventDataFacade;

/**
 *
 * @author mihai
 */
@UIScoped
public class EventDataViewPresenter extends AbstractPresenter<EventDataView> {

    @Inject
    EventDataFacade evf;

    @Override
    protected void onViewEnter() {

        getView().showGPSEvents(evf.findByAccountID(GTSVaadinUI.getApp().getAccountID()));
    }

}
