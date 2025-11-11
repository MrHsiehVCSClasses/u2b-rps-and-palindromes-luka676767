package u4pp;

/**
* JAVADOC HERE
*/
import java.util.Scanner;

public class RockPaperScissors {

    /* any code you need here for part b */

    /**
     * This helps keep track out data and add wins and loses as well as display wins and loses 
     */
    public static void play(Scanner pp) {
        System.out.println("Welcome to Rock Paper Scissors");
        int ws = 0;
        int ls = 0;
        int tie = 0;
        boolean keepPlaying = true;
        while (keepPlaying) {
            int result = doIt(pp);
            if (result == 1) {
                ws++;
            } else if (result == 0) {
                tie++;
            } else {
                ls++;
            }
            System.out.println("You have " + ws + " wins and " + ls + " losses and " + tie + " ties"); 
            keepPlaying = yesOrNo(pp, "Would you like to play again? (Y)es or (N)o: ");
        }
        System.out.println("Thanks for playing!");
    }


    /**
     * Here I make it incasensitive as well as set each specific possible combination of r, p and s to check if its a win, lose or tie and assigin it a specific value based on that info.
     */
    public static int results(String playerChoice, String computerChoice) {
        playerChoice = playerChoice.toLowerCase();
        computerChoice = computerChoice.toLowerCase();
        if(playerChoice.equals(computerChoice)) {
            return 0;
        }
        if ((playerChoice.equals("r") && computerChoice.equals("s")) ||
            (playerChoice.equals("p") && computerChoice.equals("r")) ||
            (playerChoice.equals("s") && computerChoice.equals("p"))) {
            return 1;
        }
        return -1;
    }

    /* 
     * Helper methods for part b
     * These should be private static methods that help organize your code
     * 
     * Recommended helper methods:
     * 1. getRandomChoice() - returns a random "r", "p", or "s"
     * 2. getPlayerChoice(Scanner sc) - prompts user and returns valid R/P/S/A input
     * 3. getYesNoInput(Scanner sc, String prompt) - prompts user and returns true/false for Y/N
     * 4. playRound(Scanner sc, int[] scores) - handles one complete round of RPS
     * 5. formatChoice(String choice) - converts "r" to "Rock", "p" to "Paper", etc.
     */
    // This randomizes the computer choice
    private static String rando() {
        int d = (int)(Math.random() * 3);
        if(d == 0) {
            return "r";
        }
        else if(d==1){
            return "p";
        }
        else{
            return "s";
        }
    }
    // This allows the player to pick and checks for invalif input
    private static String person(Scanner pp) {
        while (true) {
            System.out.print("Would you like to pick (R)ock, (P)aper, (S)cissors, or (A)ny: ");
            String t = pp.nextLine().toLowerCase();
            if (t.equals("r") || t.equals("p")|| t.equals("s")||t.equals("a")) {
                return t;
            }
            else {
                System.out.println("Invalid input, please try again");
            }
        }
    }
    //Asks if they wanna keep playin
    private static boolean yesOrNo(Scanner pp, String prompt) {
        while(true) {
            System.out.print(prompt);
            String t = pp.nextLine().toLowerCase();    
            if (t.equals("y")) {
                return true;
            } else if (t.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid Input, please try again");
            }
        }
    }

    //This does it all, it compares the two as well as gives a format based on the actual rock paper and sciccors 
    private static int doIt(Scanner pp){
        String playerChoice = person(pp);
        if (playerChoice.equals("a")) {
            playerChoice = rando();
        }
        String computerChoice = rando();
        int r = results( playerChoice,  computerChoice);
        if(r==0) {
            System.out.println("You both picked " + formatChoice(playerChoice) + ". Its a tie!");
        } 
        else if (r == 1) {
            System.out.println("You picked " + formatChoice(playerChoice) + ", and the Computer picked " + formatChoice(computerChoice) + ". You win!");
        } 
        else {
            System.out.println("You picked " + formatChoice(playerChoice) + ", and the Computer picked " + formatChoice(computerChoice) + ". You lose!");
        }
        return r;
    }
    // changes r to Rock etc
    private static String formatChoice(String choice) {
        choice = choice.toLowerCase();
        if (choice.equals("r" )) return "Rock";
        if (choice.equals("p")) return "Paper";
        if (choice.equals("s")) return "Scissors";
            return "Invalid";
    }
}