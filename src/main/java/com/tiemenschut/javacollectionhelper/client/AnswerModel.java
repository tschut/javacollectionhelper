package com.tiemenschut.javacollectionhelper.client;

public class AnswerModel {
    private String answer;
    private Object next;

    public AnswerModel(String answer, Object next) {
        super();
        this.answer = answer;
        this.next = next;
    }

    public String getAnswer() {
        return answer;
    }

    public Object getNext() {
        return next;
    }
}
