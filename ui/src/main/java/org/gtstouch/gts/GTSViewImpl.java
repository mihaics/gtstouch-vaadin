package org.gtstouch.gts;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;


import org.vaadin.cdiviewmenu.ViewMenuItem;


import com.vaadin.cdi.CDIView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import org.gtstouch.app.AbstractView;

import org.vaadin.viritin.layouts.MVerticalLayout;

@CDIView(GTSView.ID)
@ViewMenuItem(title="GTS Application")
public class GTSViewImpl extends AbstractView<GTSViewPresenter> implements
        GTSView {

    @Inject
    private Instance<GTSViewPresenter> presenterInstance;

    private Label state = new Label("Initial");
    
    public GTSViewImpl() {
    	state.setCaption("State:");
    	Button action = new Button("Do something", new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				getPresenter().doSomething();
			}
		});
		setCompositionRoot(new MVerticalLayout(state, action));
    }

    @Override
    protected GTSViewPresenter generatePresenter() {
        return presenterInstance.get();
    }

	@Override
	public void setMessage(String message) {
		state.setValue(message);
	}
}
