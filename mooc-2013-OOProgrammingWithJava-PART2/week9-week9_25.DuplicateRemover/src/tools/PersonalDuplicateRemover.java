/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author davido
 */
public class PersonalDuplicateRemover implements DuplicateRemover {
    
    private Set<String> strings;
    private int dupes;
    
    public PersonalDuplicateRemover() {
        this.strings = new HashSet<String>();
        this.dupes = 0;
    }

    @Override
    public void add(String characterString) {
        if (this.strings.contains(characterString)) {
            this.dupes++;
        }
        this.strings.add(characterString);
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return this.dupes;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return this.strings;
    }

    @Override
    public void empty() {
        this.strings = new HashSet<String>();
        this.dupes = 0;
    }
}
