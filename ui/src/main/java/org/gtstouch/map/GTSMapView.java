package org.gtstouch.map;

import org.gtstouch.app.ApplicationView;

public interface GTSMapView extends ApplicationView<GTSMapViewPresenter> {

    public static final String ID = "gtsmapview";

    void setMessage(String message);

    public void drawRoute();

}
