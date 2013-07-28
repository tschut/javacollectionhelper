package com.tiemenschut.javacollectionhelper.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class AnswerWidget extends Composite {

    private static AnswerWidgetUiBinder uiBinder = GWT.create(AnswerWidgetUiBinder.class);

    interface AnswerWidgetUiBinder extends UiBinder<Widget, AnswerWidget> {
    }

    @UiField
    protected Label        answer;
    private AnswerModel    model;
    private HandlerManager eventbus;

    public AnswerWidget(HandlerManager eventbus, AnswerModel model) {
        this.eventbus = eventbus;
        this.model = model;
        initWidget(uiBinder.createAndBindUi(this));

        answer.setText(model.getAnswer());
    }

    @UiHandler("answer")
    protected void answerClicked(ClickEvent event) {
        answer.addStyleName("selected");
        eventbus.fireEvent(new AnswerClickedEvent(model));
    }

}
