package se.ecutb.oscarjohanneson;
import java.util.Random;
import java.util.Scanner;
/**
 * The game Hangman.
 * In this game you have to guess the correct word. You can guess the howl whole at once or just one letter at a time.
 * You have eight guesses and if you not come up with the word in eight guesses its GAME OVER.
 *
 * Author Oscar Johanneson.
 */
public class App {

    //Make it possible to read input data from user.
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args)  {

        boolean keepRun = true;

        //As long keepRun is true the program will continue.
        while(keepRun) {
            //Call method printMenu
            printMenu();

            //Get input data from user. Choose between start application or quit.
            String startQuit = scan.nextLine();
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

    static void printMenu(){
        System.out.println("Welcome to the game Hangman\n");
        System.out.println("Make a selection:\n");
        System.out.println("1. Start the application");
        System.out.println("Q. Quit");
        System.out.print("Choice:");
    }

    static void runHangMan(){

        String[] wordList = {"Book", "Table", "Mirror", "Headphones", "Flower"};
        //take random word from Array and place it in randomWord.
        // Random will generate a random index witch will be used to generate a random word from wordList
        int index = new Random().nextInt(wordList.length);
        String randomWord = wordList[index];

        HangMan hangMan = new HangMan(randomWord);

        Scanner scannerInput = new Scanner(System.in);

        //As long the amount of guesses is less then maxGuesses while-loop will run.
        while(hangMan.getGuessAmount() < hangMan.getMaxGuesses()){

            //Print in console.
            System.out.println("Enter a letter or guess the whole word.");

            //Take user inputs and store it in playerGuess.
            String playerGuess = scannerInput.nextLine();
            //If player enter the whole word.

            if(playerGuess.equalsIgnoreCase(hangMan.getGameWord())){
                System.out.println("Congratz! You guessed the correct word! The word is: " + hangMan.getGameWord());
            }
            else{
                System.out.println("Sorry " + playerGuess + " is not the correct word!");
                //Set guessAmount to increases with one.
                hangMan.setGuessAmount();
            }

            //If player runs out of guesses this happens.
            if(hangMan.getGuessAmount() == hangMan.getMaxGuesses()){
                System.out.println("\nSorry! You lose!");
                System.out.println("\nThe word you looking for is " + hangMan.getGameWord());
            }

        }
    }
}


