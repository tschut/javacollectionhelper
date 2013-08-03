package com.tiemenschut.javacollectionhelper.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class AnswerWidget extends Composite {

    private static AnswerWidgetUiBinder uiBinder = GWT.create(AnswerWidgetUiBinder.class);

    interface AnswerWidgetUiBinder extends UiBinder<Widget, AnswerWidget> {
    }

    @UiField
    protected Button             answer;
    private final AnswerModel    model;
    private final HandlerManager eventbus;

    public AnswerWidget(HandlerManager eventbus, AnswerModel model, final AnswerModel otherAnswer) {
        this.eventbus = eventbus;
        this.model = model;
        initWidget(uiBinder.createAndBindUi(this));

        answer.setStylePrimaryName("pure-button");
        answer.setStyleName("pure-button-not-selected", true);
        answer.setText(model.getAnswer());

        eventbus.addHandler(AnswerClickedEvent.TYPE, new AnswerClickedEventHandler() {
            @Override
            public void onAnswerClicked(AnswerClickedEvent event) {
                if (event.getAnswer().equals(otherAnswer)) {
                    answer.setStyleName("pure-button");
                    answer.setStyleName("pure-button-not-selected", true);
                }
            }
        });
    }

    @UiHandler("answer")
    protected void answerClicked(ClickEvent event) {
        answer.setStyleName("pure-button");
        answer.setStyleName("pure-button-selected", true);
        eventbus.fireEvent(new AnswerClickedEvent(model));
    }

}
