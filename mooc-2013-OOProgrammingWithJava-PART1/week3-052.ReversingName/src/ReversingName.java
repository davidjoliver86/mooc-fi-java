import java.util.Scanner;

public class ReversingName {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Type your name: ");
        String name = reader.nextLine();
        System.out.print("In reverse order: ");
        int index = name.length() - 1;
        for (; index >= 0; index--) {
            System.out.print(name.charAt(index));
        }
    }
}
