
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be very useful.
        Scanner scanner = new Scanner(System.in);
        Tournament tournament = new Tournament(scanner);
        tournament.run();
    }
}
