package com.tiemenschut.javacollectionhelper.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class QuestionWidget extends Composite {

    private static QuestionWidgetUiBinder uiBinder = GWT.create(QuestionWidgetUiBinder.class);

    interface QuestionWidgetUiBinder extends UiBinder<Widget, QuestionWidget> {
    }

    @UiField
    protected Label question;

    public QuestionWidget(String question) {
        initWidget(uiBinder.createAndBindUi(this));

        this.question.setText(question);
    }

}
