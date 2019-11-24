/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author davido
 */
public class WordInspection {

    private final List<String> words;

    public WordInspection(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file, "UTF-8");
        this.words = new ArrayList<String>();
        while (scanner.hasNext()) {
            this.words.add(scanner.next());
        }
    }

    public int wordCount() {
        return this.words.size();
    }
    
    public List<String> wordsContainingZ() {
        List<String> filtered = new ArrayList<String>();
        for (String word : this.words) {
            if (word.toLowerCase().contains("z")) {
                filtered.add(word);
            }
        }
        return filtered;
    }
    
    public List<String> wordsEndingInL() {
        List<String> filtered = new ArrayList<String>();
        for (String word : this.words) {
            if (word.toLowerCase().endsWith("l")) {
                filtered.add(word);
            }
        }
        return filtered;
    }
    
    private boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }
        if (word.charAt(0) == word.charAt(word.length() - 1)) {
            return isPalindrome(word.substring(1, word.length() - 1));
        }
        return false;
    }
    
    public List<String> palindromes() {
        List<String> filtered = new ArrayList<String>();
        for (String word : this.words) {
            if (isPalindrome(word.toLowerCase())) {
                filtered.add(word);
            }
        }
        return filtered;
    }
    
    private boolean containsAllVowels(String word) {
        String[] vowels = {"a", "e", "i", "o", "u", "y", "ä", "ö"};
        for (String vowel : vowels) {
            if (!word.contains(vowel)) {
                return false;
            }
        }
        return true;
    }
    
    public List<String> wordsWhichContainAllVowels() {
        List<String> filtered = new ArrayList<String>();
        for (String word : this.words) {
            if (containsAllVowels(word.toLowerCase())) {
                filtered.add(word);
            }
        }
        return filtered;
    }
}
