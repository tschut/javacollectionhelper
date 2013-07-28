package com.tiemenschut.javacollectionhelper.client;

import com.google.gwt.event.shared.HandlerManager;

public class CollectionHelperPresenter {
    private CollectionHelperView view;

    public CollectionHelperPresenter(HandlerManager eventbus, final CollectionHelperView view) {
        this.view = view;

        eventbus.addHandler(AnswerClickedEvent.TYPE, new AnswerClickedEventHandler() {
            @Override
            public void onAnswerClicked(AnswerClickedEvent event) {
                Object next = event.getAnswer().getNext();
                if (next instanceof QuestionModel) {
                    view.setQuestion((QuestionModel) next);
                } else if (next instanceof FinalAnswerModel) {
                    view.setFinalAnswer((FinalAnswerModel) next);
                }
            }
        });
    }

    public void setModel(QuestionModel model) {
        view.setQuestion(model);
    }
}
