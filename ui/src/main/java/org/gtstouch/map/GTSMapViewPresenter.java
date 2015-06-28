/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gtstouch.map;

import java.util.Date;
import org.gtstouch.app.AbstractPresenter;

/**
 *
 * @author mihai
 */
class GTSMapViewPresenter extends AbstractPresenter<GTSMapView> {

    @Override
    protected void onViewEnter() {
        getView().setMessage("GTSMapViewPresenter: " + new Date());
    }

}
