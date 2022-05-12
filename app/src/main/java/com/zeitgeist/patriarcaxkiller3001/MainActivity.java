package com.zeitgeist.patriarcaxkiller3001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button generateJokeButton;
    private TextView jokeTitle;
    private TextView jokeContent;
    private ImageView jokeMeme;
    private TextView jokeIndexTextView;

    private ArrayList<Joke> jokeList;
    private int jokeIndex;
    private Joke currentJoke;
    private JokeText currentJokeText;
    private JokeMeme currentJokeMeme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateJokeButton = findViewById(R.id.generateJokeButton);
        jokeTitle = findViewById(R.id.jokeTitle);
        jokeContent = findViewById(R.id.jokeContent);
        jokeMeme = findViewById(R.id.jokeMeme);
        jokeIndexTextView = findViewById(R.id.jokeIndexTextView);

        this.initJokeText();
        this.initJokeMeme();
        this.updateJokeIndex(); //init with a random joke

        generateJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentJoke = jokeList.get(jokeIndex);

                if (JokeTypeEnum.TEXT.equals(currentJoke.getJokeType())) {
                    switchToTextDisplay();
                    currentJokeText = (JokeText) currentJoke;
                    jokeTitle.setText(currentJokeText.getTitle());
                    jokeContent.setText(currentJokeText.getContent());
                } else if (JokeTypeEnum.MEME.equals(currentJoke.getJokeType())) {
                    switchToMemeDisplay();
                    currentJokeMeme = (JokeMeme) currentJoke;
                    jokeMeme.setImageDrawable(currentJokeMeme.getDrawable());
                }

                //simply comment this line to hide the display of the joke index
                jokeIndexTextView.setText("Debug : blague numéro "+Integer.toString(jokeIndex));

                updateJokeIndex();
            }
        });
    }

    public void switchToTextDisplay() {
        jokeTitle.setVisibility(View.VISIBLE);
        jokeContent.setVisibility(View.VISIBLE);
        jokeMeme.setVisibility(View.GONE);
    }

    public void switchToMemeDisplay() {
        jokeTitle.setVisibility(View.GONE);
        jokeContent.setVisibility(View.GONE);
        jokeMeme.setVisibility(View.VISIBLE);
    }

    public void initJokeText() {
        jokeList = new ArrayList<Joke>();
        JokeText joke1 = new JokeText("Emmaüs",
                "Que donne un mec cis hétéro blanc dans un Emmaus ? \n" +
                "\n" +
                "Son avis");
        JokeText joke2 = new JokeText("Non-mixité", "C'est une lesbienne, une femme racisée et un homme trans" +
                "qui rentrent dans un bar et s'installent à une table" +"\n"+"\n"+
                "À la table d'à côté y'a un homme blanc cis hétéro qui se lève et qui hurle : \"POURQUOI " +
                "JE SUIS PAS DANS LA BLAGUE ?!\"");
        JokeText joke3 = new JokeText("Dichotomie", "C'est une meuf qui rentre dans un bar, et qui dit " +
                "\"Tous les mecs à droite, vous êtes des trous du culs ! Et tous les mecs à gauche, " +
                "vous etes des connards !\" \n\n" +
                "La y a un mec de droite qui se lève et qui dit : \"hé, mais moi je suis pas " +
                "un trou du cul !!\" Alors elle lui répond : \"hé bah va à gauche, CONNARD !\"");
        jokeList.add(joke1);
        jokeList.add(joke2);
        jokeList.add(joke3);
    }

    public void initJokeMeme() {
        Joke joke4 = new JokeMeme(getDrawable(R.drawable.meme1));
        jokeList.add(joke4);
    }

    public void updateJokeIndex() {
        this.jokeIndex = this.getRandomNumberInRange(0, jokeList.size()-1);
    }

    public int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}