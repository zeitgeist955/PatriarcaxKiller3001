package com.zeitgeist.patriarcaxkiller3001;

public class Joke {

    public Joke() {

    }

    //Vanne constructor
    public Joke(String title, String content) {
        this.title = title;
        this.content = content;
        this.jokeType = JokeTypeEnum.TEXT;
    }

    private String title;

    private String content;

    private JokeTypeEnum jokeType;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public JokeTypeEnum getJokeType() {
        return jokeType;
    }

    public void setJokeType(JokeTypeEnum jokeType) {
        this.jokeType = jokeType;
    }
}
