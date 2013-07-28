package com.tiemenschut.javacollectionhelper.client;

public class QuestionModel {
    private final String        question;
    private final AnswerModel[] answers = new AnswerModel[2];
    private final int           index;

    public QuestionModel(String question, int index, AnswerModel firstAnswer, AnswerModel secondAnswer) {
        this.question = question;
        this.index = index;
        this.answers[0] = firstAnswer;
        this.answers[1] = secondAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public AnswerModel[] getAnswers() {
        return answers;
    }

    public int getIndex() {
        return index;
    }
}
