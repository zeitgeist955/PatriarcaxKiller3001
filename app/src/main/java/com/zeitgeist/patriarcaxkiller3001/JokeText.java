package com.zeitgeist.patriarcaxkiller3001;

public class JokeText extends Joke {

    private String title;

    private String content;

    public JokeText(String title, String content) {
        this.title = title;
        this.content = content;
        this.jokeType = JokeTypeEnum.TEXT;
    }

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
}
