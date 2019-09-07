package se.ecutb.oscarjohanneson;

import java.util.Random;

public class RandomWord {

    private int index;
    private String randomWord;
    //Constructor
    public RandomWord(String[] wordList){
        this.index = index;
        this.randomWord = randomWord;
    }
    public String generateRandomWord(String[] wordList){
        //take random word from Array wordList from Class App and place it in randomWord.
        // Random will generate a random index witch will be used to generate a random word from wordList
        index = new Random().nextInt(wordList.length);
        randomWord = wordList[index].toLowerCase();
        return randomWord;
    }
}
