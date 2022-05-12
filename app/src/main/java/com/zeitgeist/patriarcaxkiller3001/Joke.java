package com.zeitgeist.patriarcaxkiller3001;

public abstract class Joke {

    JokeTypeEnum jokeType;

    public Joke() {

    }

    public JokeTypeEnum getJokeType() {
        return jokeType;
    }

    public void setJokeType(JokeTypeEnum jokeType) {
        this.jokeType = jokeType;
    }
}
