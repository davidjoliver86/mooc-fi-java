/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author davido
 */
public class MindfulDictionary {

    private Map<String, String> words;
    private String filename;

    public MindfulDictionary() {
        words = new HashMap<String, String>();
    }
    
    public MindfulDictionary(String file) {
        this();
        filename = file;
    }
    
    public boolean load() {
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(":");
                words.put(parts[0], parts[1]);
            }
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }
    }
    
    public boolean save() {
        if (filename == null) {
            return false;
        }
        try {
            FileWriter writer = new FileWriter(filename);
            for (Entry entry : words.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
            writer.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public void add(String word, String translation) {
        if (words.containsKey(word)) {
            return;
        }
        words.put(word, translation);
    }

    public String translate(String word) {
        for (Entry entry : words.entrySet()) {
            if (entry.getKey().equals(word)) {
                return entry.getValue().toString();
            }
            if (entry.getValue().equals(word)) {
                return entry.getKey().toString();
            }
        }
        return null;
    }
    
    public void remove(String word) {
        for (Entry entry : words.entrySet()) {
            if (entry.getKey().equals(word) || entry.getValue().equals(word)) {
                words.remove(entry.getKey());
                return;
            }
        }
    }
}
