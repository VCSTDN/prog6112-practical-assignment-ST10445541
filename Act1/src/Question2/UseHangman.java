package Question2;

import java.util.Scanner;

public class UseHangman {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HangmanGame game = new HangmanGame();

        System.out.println("Welcome to Hangman!");
        System.out.println("You have " + game.getAttemptsLeft() + " attempts to guess the word.");

        while (!game.isGameOver()) {
            System.out.println("\nWord to guess:");
            System.out.println(game.getWordProgress());
            System.out.println("Incorrect guesses: " + game.getIncorrectGuesses());
            System.out.println("Attempts left: " + game.getAttemptsLeft());
            System.out.print("Enter a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (game.guessLetter(guess)) {
                System.out.println("Good guess!");
            } else {
                System.out.println("Incorrect guess.");
            }

            if (game.isGameWon()) {
                System.out.println("Congratulations! You've guessed the word: " + game.getWordToGuess());
                break;
            }
        }

        if (!game.isGameWon()) {
            System.out.println("Sorry, you've run out of attempts. The word was: " + game.getWordToGuess());
        }

        scanner.close();
    }
}
