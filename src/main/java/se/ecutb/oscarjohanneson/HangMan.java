package se.ecutb.oscarjohanneson;

import java.util.Scanner;

public class HangMan {

    private String gameWord;    //The word that player are guessing.
    private int guessAmount;    //Amount of guesses player have done. Set to 1 by constructor.
    private int maxGuesses;     //Amount of guesses player have until game over. Set to 8 by the constructor.
    private char[] wordToGuess; //Char array that is later used to store the gameWord, letter by letter.
    private StringBuilder stringBuilder = new StringBuilder();

    //constructor.
    public HangMan(String gameWord) {
        this.gameWord = gameWord;
        this.guessAmount = 1;   //Starting guessAmount on 1.
        this.maxGuesses = 8;    //Player has 8 Guesses before game over.
    }

    //Getters
    public int getGuessAmount(){
        return guessAmount;
    }

    public int getMaxGuesses(){
        return maxGuesses;
    }

    public String getGameWord(){
        return gameWord;
    }

    //Setter
    public void setGuessAmount(){
        this.guessAmount++;
    }

    //Method to convert String gameWord to a char array.
    public char[] ConvertToChar(String word){
        this.wordToGuess = gameWord.toCharArray();
        return wordToGuess;
    }
}

