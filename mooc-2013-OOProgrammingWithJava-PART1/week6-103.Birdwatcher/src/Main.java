
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // implement your program here
        // do not put all to one method/class but rather design a proper structure to your program

        // Your program should use only one Scanner object, i.e., it is allowed to call 
        // new Scanner only once. If you need scanner in multiple places, you can pass it as parameter
        Scanner scanner = new Scanner(System.in);
        BirdDatabase database = new BirdDatabase();
        
        while (true) {
            System.out.print("? ");
            String command = scanner.nextLine();
            if ("Add".equals(command)) {
                String name, latinName;
                System.out.print("Name: ");
                name = scanner.nextLine();
                System.out.print("Latin Name: ");
                latinName = scanner.nextLine();
                database.add(name, latinName);
            }
            if ("Observation".equals(command)) {
                System.out.print("What was observed:? ");
                database.observe(scanner.nextLine());
            }
            if ("Statistics".equals(command)) {
                database.statistics();
            }
            if ("Show".equals(command)) {
                System.out.print("What? ");
                database.show(scanner.nextLine());
            }
            if ("Quit".equals(command)) {
                break;
            }
        }
    }
}
