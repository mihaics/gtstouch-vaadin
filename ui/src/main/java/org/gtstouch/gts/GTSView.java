package org.gtstouch.gts;

import org.gtstouch.app.ApplicationView;




public interface GTSView extends ApplicationView<GTSViewPresenter> {
    
    public static final String ID = "gtsview";
	
	void setMessage(String message);

}
