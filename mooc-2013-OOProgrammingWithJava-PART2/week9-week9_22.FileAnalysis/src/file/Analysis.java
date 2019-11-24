/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author davido
 */
public class Analysis {
    
    private final File file;
    
    public Analysis(File file) {
        this.file = file;
    }
    
    public int lines() throws FileNotFoundException {
        Scanner scanner = new Scanner(this.file);
        int lines = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            lines++;
        }
        return lines;
    }

    public int characters() throws FileNotFoundException {
        Scanner scanner = new Scanner(this.file);
        int chars = 0;
        while (scanner.hasNextLine()) {
            chars += scanner.nextLine().length() + 1;
        }
        return chars;
    }
}
