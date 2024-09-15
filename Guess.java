import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Scanner;

class Guess {
    public static void main(String[] args) {
        int min = 1;
        int max = 100;
        int max_attempts = 5;
        int total_score = 0;
        int rounds = 2;
        int roundNumber = 0;
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);
        JOptionPane.showMessageDialog(null, "Welcome to GUESS THE NUMBER!");
        JOptionPane.showMessageDialog(null, "There are " + rounds + " rounds in total and each round has " + max_attempts + " attempts.");

        for (int i = 1; i <= rounds; i++) { 
            roundNumber++;
            int number = r.nextInt(max) + min;
            int attempts = 0;

            System.out.println("Round " + roundNumber + ":");

            while (attempts < max_attempts) {
                System.out.print("Enter your guess: ");
                String guessStr = scanner.nextLine();
                int guess = Integer.parseInt(guessStr); 
                attempts++;

                if (guess == number) {
                    int score = max_attempts - attempts;
                    total_score += score;
                    System.out.println("Congratulations! You guessed the correct number.");
                    break;
                } else if (guess < number) {
                    System.out.println("The number is greater than " + guess + ". Try again. Attempts left: " + (max_attempts - attempts));
                } else {
                    System.out.println("The number is smaller than " + guess + ". Try again. Attempts left: " + (max_attempts - attempts));
                }
            }

            if (attempts == max_attempts) {
                System.out.println("Sorry, you've used all " + max_attempts + " attempts. The number was " + number + ".");
            }
        }

        JOptionPane.showMessageDialog(null, "Total Score is: " + total_score);
    }
}