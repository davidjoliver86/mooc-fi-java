/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import phonebook.entity.Address;
import phonebook.entity.PersonalInfo;
import phonebook.entity.PhoneNumber;

/**
 *
 * @author davido
 */
public class Phonebook {
    private Map<String, List<PersonalInfo>> phonebook;
    
    public Phonebook() {
        this.phonebook = new HashMap<String, List<PersonalInfo>>();
    }
    
    private void initializePerson(String name) {
        if (!phonebook.containsKey(name)) {
            phonebook.put(name, new ArrayList<PersonalInfo>());
        }
    }

    public void addNumber(String name, String number) {
        initializePerson(name);
        phonebook.get(name).add(new PhoneNumber(number));
    }

    public List<PhoneNumber> searchForNumber(String name) {
        if (!phonebook.containsKey(name)) {
            return null;
        }
        List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
        for (PersonalInfo info : phonebook.get(name)) {
            if (info instanceof PhoneNumber) {
                phoneNumbers.add((PhoneNumber) info);
            }
        }
        return phoneNumbers;
    }
    
    public String searchForPersonByNumber(String number) {
        for (String name : phonebook.keySet()) {
            for (PersonalInfo info : phonebook.get(name)) {
                if (info instanceof PhoneNumber && info.get().equals(number)) {
                    return name;
                }
            }
        }
        return null;
    }

    public void addNumber(String name, String street, String city) {
        initializePerson(name);
        phonebook.get(name).add(new Address(street, city));
    }

    public List<PersonalInfo> getPersonalInfo(String name) {
        if (!phonebook.containsKey(name)) {
            return null;
        }
        return phonebook.get(name);
    }
    
    public List<String> getAllNames() {
        List<String> names = new ArrayList<String>(this.phonebook.keySet());
        Collections.sort(names);
        return names;
    }

    public void deletePersonalInfo(String name) {
        phonebook.remove(name);
    }
}
