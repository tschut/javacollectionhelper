package com.tiemenschut.javacollectionhelper.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

public class JavaCollectionHelper implements EntryPoint {
    @Override
    public void onModuleLoad() {
        HandlerManager eventbus = new HandlerManager(null);
        final CollectionHelperView view = new CollectionHelperView(eventbus);
        final CollectionHelperPresenter presenter = new CollectionHelperPresenter(eventbus, view);
        presenter.setModel(ModelBuilder.build());

        RootPanel.get("container").add(view);
    }
}
