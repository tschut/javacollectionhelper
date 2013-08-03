package com.tiemenschut.javacollectionhelper.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

public class JavaCollectionHelper implements EntryPoint {
    @Override
    public void onModuleLoad() {
        breakOut();

        HandlerManager eventbus = new HandlerManager(null);
        final CollectionHelperView view = new CollectionHelperView(eventbus);
        final CollectionHelperPresenter presenter = new CollectionHelperPresenter(eventbus, view);
        presenter.setModel(ModelBuilder.build());

        RootPanel.get("container").add(view);
    }

    public native void breakOut() /*-{
		if ($wnd.top.location == $wnd.location) {
			$wnd.top.location = "http://www.tiemenschut.com/which-java-collection-class-to-use";
		}
    }-*/;
}
