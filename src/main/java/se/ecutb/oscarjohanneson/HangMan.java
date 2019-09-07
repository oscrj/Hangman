package se.ecutb.oscarjohanneson;

import java.util.ArrayList;

public class HangMan {

    private String gameWord;    //The word that player are guessing.
    private int guessAmount;    //Amount of guesses player have done. Set to 1 by constructor.
    private int maxGuesses;     //Amount of guesses player have until game over. Set to 8 by the constructor.
    private char[] wordToGuess; //Char array that is later used to store the gameWord, letter by letter.
    private StringBuilder stringBuilder = new StringBuilder();
    private ArrayList<String> letters = new ArrayList<>();  //A list of Letters that's stored from user input.
    //constructor.
    public HangMan(String gameWord) {
        this.gameWord = gameWord;
        this.guessAmount = 1;   //Starting guessAmount on 1.
        this.maxGuesses = 8;    //Player has 8 Guesses before game over.
        this.stringBuilder = stringBuilder;
        this.wordToGuess = wordToGuess;
        this.letters = letters;
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
    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }
    //Method to start a new game. This will make the game restore guessAmount to 1 and clear ArrayList.
    public void newGame(){
        //clear ArrayList letter.
        letters.clear();
        //Create a new char from gameWord
        wordToGuess = new char[gameWord.length()];
        for(int i = 0; i < wordToGuess.length; i++){
            wordToGuess[i] = '_';
        }
    }
    //Compare if _ is equal to our gameWord.
    public boolean isWordFound(){
        return gameWord.contentEquals(new String(wordToGuess));
    }
    //Method that will print out char array and show progress for the player.
    public String wordFoundContent(){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < wordToGuess.length; i++){
            builder.append(wordToGuess[i]);
            //Adding a space between every char. This will help player to see how many letters the word contains.
            // -1 is used for not setting a space after last letter in Array wordToGuess.
            if(i < wordToGuess.length - 1){
               builder.append(" ");
            }
        }
        return builder.toString();
    }
    //Method that will compare the game word with players guesses.
    public void inputPlayerGuess(String guessInput){
        //Update only if input already been entered.
        if(!letters.contains(guessInput)){
            //Check if gameWord contains input.
            if(gameWord.contains(guessInput)){
                //If it does, _ replaces with character from input.
                int index = gameWord.indexOf(guessInput);
                //print input data from user.
                stringBuilder.append(" " + guessInput +" ");
                while(index >= 0){
                    wordToGuess[index] = guessInput.charAt(0);
                    index = gameWord.indexOf(guessInput, index + 1);
                }
            } else{
                //If input is not in the word.
                guessAmount++;
                stringBuilder.append(" "+ guessInput + " ");
            }
            //Add input to Array letters.
            letters.add(guessInput);
        }
    }
}

