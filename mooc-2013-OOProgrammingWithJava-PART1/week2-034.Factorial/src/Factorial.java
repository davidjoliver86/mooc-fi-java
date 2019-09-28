import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Type a number ");
        int n = reader.nextInt();
        int answer = 1;
        if (n >= 1) {
            for (; n > 0; --n) {
                answer *= n;
            }
        }
        System.out.println("Factorial is " + answer);
    }
}
