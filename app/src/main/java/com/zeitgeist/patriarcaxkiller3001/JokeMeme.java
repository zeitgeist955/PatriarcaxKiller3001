package com.zeitgeist.patriarcaxkiller3001;

import android.graphics.drawable.Drawable;

public class JokeMeme extends Joke {

    private Drawable drawable;

    public JokeMeme(Drawable drawable) {
        this.drawable = drawable;
        this.jokeType = JokeTypeEnum.MEME;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
}
