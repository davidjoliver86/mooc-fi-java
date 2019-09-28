
import java.util.Scanner;

public class TheSumOfSetOfNumbers {

    public static void main(String[] args) {
        System.out.print("Until what? ");
        Scanner reader = new Scanner(System.in);
        int limit = reader.nextInt();
        int sum = 0;
        for (int i = 1; i <= limit; i++) {
            sum += i;
        }
        System.out.println("Sum is " + sum);
    }
}
