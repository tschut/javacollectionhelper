package com.tiemenschut.javacollectionhelper.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class FinalAnswerWidget extends Composite {

    private static FinalAnswerWidgetUiBinder uiBinder = GWT.create(FinalAnswerWidgetUiBinder.class);

    interface FinalAnswerWidgetUiBinder extends UiBinder<Widget, FinalAnswerWidget> {
    }

    @UiField
    protected Anchor finalAnswer;

    public FinalAnswerWidget(FinalAnswerModel model) {
        initWidget(uiBinder.createAndBindUi(this));
        finalAnswer.addStyleName("selected");
        finalAnswer.setText(model.getAnswer());
        finalAnswer.setHref(model.getUrl());
    }

}
