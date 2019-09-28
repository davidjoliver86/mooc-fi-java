
import java.util.Scanner;


public class TheSumBetweenTwoNumbers {
    public static void main(String[] args) {
        System.out.print("Until what? ");
        Scanner reader = new Scanner(System.in);
        System.out.print("First: ");
        int first = reader.nextInt();
        System.out.print("Last: ");
        int last = reader.nextInt();
        int sum = 0;
        for (int i = first; i <= last; i++) {
            sum += i;
        }
        System.out.println("The sum is " + sum);
    }
}
