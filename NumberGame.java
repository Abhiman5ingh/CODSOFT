import java.util.Scanner;
import java.util.Random;
class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int Attempts = 7;
        boolean Again;
        System.out.println("Welcome to the Number Guessing Game!");
        do {
            int randomNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean isGuessed = false;
            System.out.printf("I have chosen a number between %d and %d. Can you guess it?\n", min, max);

            while (attempts < Attempts && !isGuessed) {
                System.out.printf("Attempt %d of %d: Enter your guess: ", attempts + 1, Attempts);
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    isGuessed = true;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            if (!isGuessed) {
                System.out.printf("Sorry! You've used all %d attempts. The correct number was %d.\n", Attempts, randomNumber);
            }
            System.out.print("Do you want to play again? (Y/N): ");
            Again = sc.next().equalsIgnoreCase("Y");
        } while (Again);

        System.out.println("Thank you for playing the Number Guessing Game. Goodbye!");
        sc.close();
    }
}