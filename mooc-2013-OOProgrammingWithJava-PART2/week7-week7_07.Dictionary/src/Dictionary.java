
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Dictionary {

    private final HashMap<String, String> dictionary;
    
    public Dictionary() {
        this.dictionary = new HashMap<String, String>();
    }

    public void add(String finnish, String english) {
        this.dictionary.put(finnish, english);
    }

    public String translate(String finnish) {
        return this.dictionary.get(finnish);
    }

    public int amountOfWords() {
        return this.dictionary.size();
    }

    public ArrayList<String> translationList() {
        ArrayList<String> translations = new ArrayList<String>();
        for (String key : this.dictionary.keySet()) {
            translations.add(String.format("%s = %s", key, this.dictionary.get(key)));
        }
        return translations;
    }
}
