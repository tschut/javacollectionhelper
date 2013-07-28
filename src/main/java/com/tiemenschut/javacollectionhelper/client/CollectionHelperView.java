package com.tiemenschut.javacollectionhelper.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class CollectionHelperView extends Composite {

    private static final int                    ROWS_PER_QUESTION = 2;

    private static CollectionHelperViewUiBinder uiBinder          = GWT.create(CollectionHelperViewUiBinder.class);

    interface CollectionHelperViewUiBinder extends UiBinder<Widget, CollectionHelperView> {
    }

    @UiField
    protected FlexTable    maintable;

    private int            currentQuestions = 0;

    private HandlerManager eventbus;

    public CollectionHelperView(HandlerManager eventbus) {
        initWidget(uiBinder.createAndBindUi(this));
        this.eventbus = eventbus;
    }

    public void setQuestion(QuestionModel question) {
        int index = question.getIndex() * ROWS_PER_QUESTION;
        rollbackTo(index);
        maintable.setWidget(index, 0, new QuestionWidget(question.getQuestion()));
        maintable.getFlexCellFormatter().setColSpan(index, 0, 2);
        maintable.setWidget(index + 1, 0, new AnswerWidget(eventbus, question.getAnswers()[0]));
        maintable.setWidget(index + 1, 1, new AnswerWidget(eventbus, question.getAnswers()[1]));
        currentQuestions = question.getIndex() + 1;
    }

    private void rollbackTo(int index) {
        for (int i = index; i < currentQuestions * ROWS_PER_QUESTION; ++i) {
            maintable.removeRow(index);
        }
    }

    public void setFinalAnswer(FinalAnswerModel next) {
        int index = currentQuestions * ROWS_PER_QUESTION;
        maintable.setWidget(index, 0, new FinalAnswerWidget(next));
        maintable.getFlexCellFormatter().setColSpan(index, 0, 2);
    }
}
