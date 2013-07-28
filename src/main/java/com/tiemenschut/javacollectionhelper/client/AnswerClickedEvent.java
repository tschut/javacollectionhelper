package com.tiemenschut.javacollectionhelper.client;

import com.google.gwt.event.shared.GwtEvent;

public class AnswerClickedEvent extends GwtEvent<AnswerClickedEventHandler> {
    public static Type<AnswerClickedEventHandler> TYPE = new Type<AnswerClickedEventHandler>();

    private final AnswerModel                     answer;

    public AnswerClickedEvent(AnswerModel answer) {
        this.answer = answer;
    }

    public AnswerModel getAnswer() {
        return answer;
    }

    @Override
    public Type<AnswerClickedEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(AnswerClickedEventHandler handler) {
        handler.onAnswerClicked(this);
    }

}
