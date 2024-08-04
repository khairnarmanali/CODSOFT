import java.util.*;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int roundsWon = 0;

        while (playAgain) {
            int numberToGuess = random.nextInt(100);
            int numberOfAttempts = 10;
            boolean hasGuessedCorrectly = false;

            System.out.println("A New number is Generated! Try to guess it (between 1 and 100):");

            for (int attempt = 1; attempt <= numberOfAttempts; attempt++) {
                System.out.print("Attempt " + attempt + ": ");
                int userGuess = sc.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You Guessed The Correct Number:)");
                    hasGuessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try an higher number");
                } else {
                    System.out.println("Too high! Try an lower number");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry! You've used all attempts. The Number was: " + numberToGuess);
            }

            System.out.print("Wish to play it again? (yes/no): ");
            
            playAgain = sc.next().equalsIgnoreCase("yes");
        }

        System.out.println("YOU WON:)" +  roundsWon + " rounds.");
        sc.close();
    }
}
