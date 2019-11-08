
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author davido
 */
public class Printer {
    
    private File file;
    
    public Printer(String filename) throws FileNotFoundException {
        this.file = new File(filename);
    }
    
    public void printLinesWhichContain(String word) throws FileNotFoundException {
        Scanner scanner = new Scanner(this.file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(word)) {
                System.out.println(line);
            }
        }
    }
    
}
