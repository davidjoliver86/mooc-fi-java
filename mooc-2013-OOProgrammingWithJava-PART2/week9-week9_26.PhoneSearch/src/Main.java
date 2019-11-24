
import java.util.Scanner;
import phonebook.ui.PhonebookUI;


public class Main {

    public static void main(String[] args) {
        new PhonebookUI(new Scanner(System.in)).run();
    }
}
