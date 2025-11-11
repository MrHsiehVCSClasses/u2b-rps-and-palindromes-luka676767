package u4pp;
import java.util.Scanner;

public class PalindromeTester {
// I set up my scanner 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        execute(sc);
    }

    /**
     * Starts the loop, and make sure to run while the user wants to (aka when user input is Y, sets keeplaying to false when N)
     */
    public static void execute(Scanner sc) {
        System.out.println("Welcome to Palindrome Tester");
        boolean keepTesting = true;

        while (keepTesting) {
            System.out.print("Enter a phrase: ");
            String input = sc.nextLine();

            if (isPalindrome(input)) {
                System.out.println(input + " is a palindrome");
            } else {
                System.out.println(input + " is not a palindrome");
            }

            keepTesting = yesOrNo(sc, "Keep testing? (Y)es or (N)o: ");
        }
    }

    /**
     * This sets the actucal palindrome to a new string and makes sure the string isn't nothing, just makes sure the palindrome can be checked (true or false, )
     */
    public static boolean isPalindrome(String s) {
        if (s == null) return false;
        String filtered = diffString(s);
        return checkPalindrome(filtered);
    }

    // Remove everything except letters and make lowercase
     private static String diffString(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                result += Character.toLowerCase(c);
            }
        }
        return result;
    }

    // Check if the filtered string reads the same forwards and backwards
    private static boolean checkPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    /**
     * Returns true for Yes, false for No.
     * Keeps prompting until valid Y or N (case-insensitive).
     */
    public static boolean yesOrNo(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("Y")) return true;
            if (line.equalsIgnoreCase("N")) return false;
            System.out.println("Invalid Input, please try again");
        }
    }
}