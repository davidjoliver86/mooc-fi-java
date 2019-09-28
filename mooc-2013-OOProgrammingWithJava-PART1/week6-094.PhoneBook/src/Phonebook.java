
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author davido
 */
public class Phonebook {
    
    private ArrayList<Person> people;
    
    public Phonebook() {
        this.people = new ArrayList<Person>();
    }
    
    public void add(String name, String number) {
        this.people.add(new Person(name, number));
    }
    
    public void printAll() {
        for (Person p : people) {
            System.out.println(p);
        }
    }
    
    public String searchNumber(String name) {
        for (Person p : people) {
            if (p.getName().equals(name)) {
                return p.getNumber();
            }
        }
        return "number not known";
    }
}
