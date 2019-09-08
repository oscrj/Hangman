package se.ecutb.oscarjohanneson;

import java.util.Scanner;
/**
 * The game Hangman.
 * In this game you have to guess the correct word. You can guess the howl whole at once or just one letter at a time.
 * You have eight guesses and if you not come up with the word in eight guesses its GAME OVER.
 */
public class App {

    //Make it possible to read input data from user.
    static Scanner scannerInput = new Scanner(System.in);

    public static void main(String[] args)  {

        boolean keepRun = true;
        //As long keepRun is true the program will continue.
        while(keepRun) {
            //Call method printMenu
            printMenu();
            //Get input data from user. Choose between start application or quit.
            String startQuit = scannerInput.nextLine();
            switch (startQuit) {
                case "1":
                    runHangMan();
                    break;
                case "Q": case "q":
                    //If user enter Q or q as input application quits. keepRun = false and break the while-loop.
                    System.out.println("Quit....");
                    keepRun = false;
                    break;
                default:
                    System.out.println("\nYou have to choose 1 or Q\n");
            }
        }
    }
    //Method to print menu.
    static void printMenu(){
        System.out.println("Welcome to the game Hangman\n");
        System.out.println("Make a selection:\n");
        System.out.println("1. Start a new game");
        System.out.println("Q. Quit");
        System.out.print("Choice:");
    }
    //method to run HangMan Game.
    static void runHangMan(){
        //String array containing words that is going to be randomly picked.
        String[] wordList = {"Books", "Table", "Mirror", "Headphones", "Flower"};
        //Create String playerGuess to store input data from player using Scanner.
        String playerGuess;
        //Instancing class RandomWord and give the constructor array wordList.
        RandomWord randomWord = new RandomWord(wordList);
        //Instancing class HangMan and call the method generateRandomWord in class RandomWord to get back a random word to play with.
        HangMan hangMan = new HangMan(randomWord.generateRandomWord(wordList));
        //Calling method newGame.
        hangMan.newGame();
        //As long the amount of guesses is less then maxGuesses while-loop will run.
        while(hangMan.getGuessAmount() < hangMan.getMaxGuesses()){
            System.out.println("\nEnter a letter or guess the whole word.");
            //print out charArray wordToGuess to give the player a hint on amount of number gameWord contains.
            System.out.println("\n" + hangMan.wordFoundContent());
            try{
                //Take user inputs and store it in playerGuess.
                playerGuess = scannerInput.nextLine().toLowerCase();
                //A stupid but a simple way to see if player guessed the whole word correct.
                if(playerGuess.equalsIgnoreCase(hangMan.getGameWord())){
                    System.out.println("\nYou won!\t" + " The word was ---> " + hangMan.getGameWord() + " <---");
                    System.out.println("Continue by pressing enter....");
                    //Make a break to study the result.
                    scannerInput.nextLine();
                    break;
                }
                //Keep only the first letter.
                if(playerGuess.length() > 1){
                    playerGuess = playerGuess.substring(0, 1);
                }
                //Call method inputPlayerGuess.
                hangMan.inputPlayerGuess(playerGuess);
                //Display current stats for the player using charArray wordToGuess.
                System.out.println("\n" + hangMan.wordFoundContent());
                System.out.println("Your guessed letters: " + hangMan.getStringBuilder());
                //Checking if word is found.
                if(hangMan.isWordFound()){
                    System.out.println("\nYou won!\t" + " The word was ---> " + hangMan.getGameWord() + " <---");
                    System.out.println("Continue by pressing enter....");
                    //Make a break to study the result.
                    scannerInput.nextLine();
                    break;
                }else{
                    //Display number of tries remaining for the player.
                    System.out.println("\nNumber of tries remaining " + (hangMan.getMaxGuesses() - hangMan.getGuessAmount()));
                }
            }catch (Exception e){
                System.out.println("\nInvalid data. Please enter a letter or a word");
            }
        }
        //If player runs out of guesses this happens.
        if(hangMan.getGuessAmount() == hangMan.getMaxGuesses()){
            System.out.println("\nGAME OVER! You lose!");
            System.out.println("\nThe word you looking for is " + hangMan.getGameWord());
            System.out.println("\nContinue by pressing enter....");
            //Make a break to study the result.
            scannerInput.nextLine();
        }
    }
}


