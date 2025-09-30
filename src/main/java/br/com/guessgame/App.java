package br.com.guessgame;

import java.util.Random;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int random = generateRandomNumber();
            showMenu();

            Difficulty choice = getDifficulty(scanner);

            System.out.println("Great! You have selected the " + choice.getName() + " difficulty level.");
            System.out.println("Let's start the game!");

            int chances = switch (choice) {
                case EASY -> 10;
                case MEDIUM -> 5;
                case HARD -> 3;
            };
            int attempts = 0;
            boolean won = false;

            do {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                chances--;

                if (guess == random) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    won = true;
                    break;
                } else if (guess > random) {
                    System.out.println("Incorrect! The number is less than " + guess + ".");
                } else {
                    System.out.println("Incorrect! The number is greater than " + guess + ".");
                }
            } while (chances > 0);

            if (!won) {
                System.out.println("You lose the game! The number was " + random + ".");
            }
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    private static Difficulty getDifficulty(Scanner scanner) {
        int option;
        boolean isInvalidOption;

        do {
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            isInvalidOption = option < 1 || option > 3;

            if (isInvalidOption) {
                System.out.println("Invalid option type a number between 1-3");
            }
        } while (isInvalidOption);

        return Difficulty.values()[option - 1];
    }

    private static void showMenu() {
        String menu = """
                    Welcome to the Number Guessing Game!
                    I'm thinking of a number between 1 and 100.
                    
                    Please select the difficulty level:
                    1. Easy (10 chances)
                    2. Medium (5 chances)
                    3. Hard (3 chances)
                    
                    """;

        System.out.print(menu);
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(1, 101);
    }
}