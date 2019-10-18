
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class TextUserInterface {

    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        System.out.println("Statements: ");
        System.out.println("add - adds a word pair to the dictionary");
        System.out.println("translate - asks a word and prints its translation");
        System.out.println("quit - quits the text user interface");
        while (true) {
            String command = reader.nextLine();
            if ("quit".equals(command)) {
                System.out.println("Cheers!");
                break;
            }
            if ("add".equals(command)) {
                add();
            }
            if ("translate".equals(command)) {
                translate();
            }
        }
    }
    
    public void add() {
        System.out.print("In Finnish: ");
        String finnish = reader.nextLine();
        System.out.print("Translation: ");
        String english = reader.nextLine();
        this.dictionary.add(finnish, english);
    }
    
    public void translate() {
        System.out.println("Give a word: ");
        String finnish = reader.nextLine();
        System.out.print("Translation: " + this.dictionary.translate(finnish));
    }

}
