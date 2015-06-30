package org.gtstouch.map;

import com.vaadin.cdi.CDIView;
import com.vaadin.data.Property;
import com.vaadin.data.util.converter.Converter;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Notification;
import java.util.Date;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import org.gtstouch.app.AbstractView;

import org.vaadin.cdiviewmenu.ViewMenuItem;
import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.LOpenStreetMapLayer;
import org.vaadin.addon.leaflet.LPolyline;
import org.vaadin.viritin.layouts.MHorizontalLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

@CDIView(GTSMapView.ID)
@ViewMenuItem(icon = FontAwesome.LIFE_BOUY)
public class GTSMapViewImpl extends AbstractView<GTSMapViewPresenter> implements GTSMapView {

    @Inject
    private Instance<GTSMapViewPresenter> presenterInstance;

    MVerticalLayout mapLayout = new MVerticalLayout();
    //  @Inject
    //  GPSRouteService service;
    LMap map = new LMap();
    LPolyline snake;

    DateField start = new DateField("From");
    DateField end = new DateField("To");

    static final long DAY = 24 * 60 * 60 * 1000;
    static final long ONE_WEEK = 7 * DAY;

    static final Date periodEnd = new Date();
    static final Date periodStart = new Date(periodEnd.getTime() - DAY);

    public GTSMapViewImpl() {

        mapLayout.add(new MHorizontalLayout(start, end));
        map.addLayer(new LOpenStreetMapLayer());
        map.setCenter(46.27, 21.24);
        map.setZoomLevel(9);

        mapLayout.expand(map);
        setCompositionRoot(mapLayout);

    }

    protected void prepareDateRangeSelector() throws Property.ReadOnlyException, Converter.ConversionException {
        start.setRangeStart(periodStart);
        start.setRangeEnd(periodEnd);
        end.setRangeStart(periodStart);
        end.setRangeEnd(periodEnd);
        start.setValue(periodStart);
        end.setValue(new Date(periodStart.getTime() + ONE_WEEK));
        start.addValueChangeListener(e -> {
            long maxEnd = start.getValue().getTime() + ONE_WEEK;
            if (end.getValue().getTime() > maxEnd) {
                end.setValue(new Date(maxEnd));
            } else if (end.getValue().getTime() < start.getValue().getTime()) {
                end.setValue(new Date(start.getValue().getTime() + DAY));
            }
            drawRoute();
        });
        end.addValueChangeListener(e -> {
            long minStart = end.getValue().getTime() - ONE_WEEK;
            if (start.getValue().getTime() < minStart) {
                start.setValue(new Date(minStart));
            } else if (start.getValue().getTime() > end.getValue().getTime()) {
                start.setValue(new Date(end.getValue().getTime() - DAY));
            }
            drawRoute();
        });
    }

    public void drawRoute() {

        //Notification.show("Entering Map View, draw route", Notification.Type.TRAY_NOTIFICATION);

        /*   List<Update> updates = service.fetchUpdates(start.getValue(), end.
         getValue());
         if (!updates.isEmpty()) {
         List<Point> points = updates.stream()
         .map(u -> new Point(u.getLat(), u.getLon()))
         .collect(Collectors.toList());
         if (snake != null) {
         snake.setPoints(points.toArray(new Point[points.size()]));
         } else {
         snake = new LPolyline(points.toArray(new Point[points.size()]));
         map.addLayer(snake);
         }
         map.zoomToContent();
         } else {
         Notification.show("No points found from the selected perioud");
         if (snake != null) {
         map.removeLayer(snake);
         snake = null;
         }

         }
         */
    }

    @Override
    public void setMessage(String message) {

    }

    @Override
    protected GTSMapViewPresenter generatePresenter() {
        return presenterInstance.get();

    }

}
