package org.gtstouch.app;

public interface ApplicationView<P extends AbstractPresenter> {

    P getPresenter();

    String getName();

    String getId();
}
