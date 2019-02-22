package com.wolasoft.jokes_lib;

import java.util.Random;

public class Joke {

    private final String[] jokes = {
            "I was born in California. Which part? All of me.",
            "Why did the Clydesdale give the pony a glass of water? Because he was a little horse.",
            "What do you call an alligator detective? An investi-gator.",
            "What lights up a soccer stadium? A soccer match.",
            "What’s brown and sticky? A stick."
    };

    public Joke() {
    }

    public int getRandomInteger() {
        Random random = new Random();

        return random.nextInt(jokes.length);
    }

    public String sayJoke() {
        return jokes[getRandomInteger()];
    }
}
