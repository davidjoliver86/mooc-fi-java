
import java.util.Scanner;

public class WordInsideWord {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Type the first word: ");
        String word1 = reader.nextLine();
        System.out.print("Type the second word: ");
        String word2 = reader.nextLine();
        String found = word1.indexOf(word2) > -1 ? "found" : "not found";
        System.out.printf("The word '%s' is %s in the word '%s'.", word2, found, word1);
    }
}
