package com.tiemenschut.javacollectionhelper.client;

public class FinalAnswerModel {
    private final String answer;
    private final String url;

    public FinalAnswerModel(String answer, String url) {
        super();
        this.answer = answer;
        this.url = url;
    }

    public String getAnswer() {
        return answer;
    }

    public String getUrl() {
        return url;
    }
}
