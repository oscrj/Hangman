package se.ecutb.oscarjohanneson;

public class HangMan {


    private String gameWord;
    private int guessAmount;
    private int maxGuesses;

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
}

