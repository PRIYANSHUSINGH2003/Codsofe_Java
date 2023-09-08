import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int totalAttempts = 0;
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;

            System.out.println("\nI've selected a number between " + lowerBound + " and " + upperBound + ".");

            while (true) {
                try {
                    System.out.print("Your guess: ");
                    int userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess < lowerBound || userGuess > upperBound) {
                        System.out.println("Please guess a number between " + lowerBound + " and " + upperBound + ".");
                    } else if (userGuess == numberToGuess) {
                        System.out.println("Congratulations! You guessed the number " + numberToGuess + " in " + attempts + " attempts.");
                        roundsWon++;
                        totalAttempts += attempts;
                        break;
                    } else if (attempts >= maxAttempts) {
                        System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + numberToGuess + ".");
                        totalAttempts += maxAttempts;
                        break;
                    } else if (userGuess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine(); // Clear the input buffer
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("\nGame over! You won " + roundsWon + " round(s). Average attempts per round: " + (double) totalAttempts / roundsWon);

        // Close the scanner
        scanner.close();
    }
}
