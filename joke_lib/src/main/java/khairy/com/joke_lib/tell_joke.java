package khairy.com.joke_lib;

import java.util.ArrayList;
import java.util.Random;

public class tell_joke {

    private ArrayList<String> jokeList = new ArrayList<>();
    private Random random;

    public tell_joke(){
        addJokes();
        this.random = new Random();
    }

    public String jokeTelling(){
        int index = random.nextInt(jokeList.size()-1);
        return jokeList.get(index);
    }

    public void addJokes() {

        jokeList.add("Anton, do you think I’m a bad mother? : My name is Paul");
        jokeList.add("My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away");
        jokeList.add("Q: What do you call the security outside of a Samsung Store? A: Guardians of the Galaxy.");
        jokeList.add("What is the difference between a snowman and a snowwoman? : Snowballs.");
        jokeList.add("In a boomerang shop: I'd like to buy a new boomerang please. Also, can you tell me how to throw the old one away?");
        jokeList.add("Patient: Oh doctor, I’m just so nervous. This is my first operation. Doctor: Don't worry. Mine too.");
        jokeList.add("A naked women robbed a bank. Nobody could remember her face");
    }
}
