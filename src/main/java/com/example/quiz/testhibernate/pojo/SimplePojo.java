package com.example.quiz.testhibernate.pojo;

public class SimplePojo {
    private String type;

    public SimplePojo(String type) {
        this.type = type;
    }

    public SimplePojo() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SimplePojo{" +
                "type='" + type + '\'' +
                '}';
    }
}
