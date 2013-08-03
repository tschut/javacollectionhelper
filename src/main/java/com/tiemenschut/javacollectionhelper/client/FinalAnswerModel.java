package com.tiemenschut.javacollectionhelper.client;

public class FinalAnswerModel {
    private final String answer;
    private final String url;
    private int          index;

    public FinalAnswerModel(int index, String answer, String url) {
        super();
        this.index = index;
        this.answer = answer;
        this.url = url;
    }

    public String getAnswer() {
        return answer;
    }

    public String getUrl() {
        return url;
    }

    public int getIndex() {
        return index;
    }
}
