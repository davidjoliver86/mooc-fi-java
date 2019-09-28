
import java.util.Random;
import java.util.Scanner;

public class GuessingNumberGame {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int numberDrawn = drawNumber();

        // program your solution here. Do not touch the above lines!
        System.out.print("Guess a number: ");
        int guesses = 0;
        while (true) {
            int guess = reader.nextInt();
            guesses++;
            if (guess < numberDrawn) {
                System.out.println("The number is greater, guesses made: " + guesses);
            }
            if (guess > numberDrawn) {
                System.out.println("The number is lesser, guesses made: " + guesses);
            }
            if (guess == numberDrawn) {
                System.out.println("Congratulations, your guess is correct!");
                break;
            }
        }
    }

    // DO NOT MODIFY THIS!
    private static int drawNumber() {
        return new Random().nextInt(101);
    }
}
