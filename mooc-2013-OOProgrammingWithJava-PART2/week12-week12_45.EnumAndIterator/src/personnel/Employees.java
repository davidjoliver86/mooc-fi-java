/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author davido
 */
public class Employees {

    private List<Person> persons;

    public Employees() {
        this.persons = new ArrayList<Person>();
    }

    public void add(Person person) {
        this.persons.add(person);
    }

    public void add(List<Person> persons) {
        for (Person p : persons) {
            this.persons.add(p);
        }
    }

    public void print() {
        for (Person p : this.persons) {
            System.out.println(p);
        }
    }

    public void print(Education edu) {
        Iterator<Person> persons = this.persons.iterator();
        while (persons.hasNext()) {
            Person p = persons.next();
            if (p.getEducation() == edu) {
                System.out.println(p);
            }
        }
    }
    
    public void fire(Education edu) {
        Iterator<Person> persons = this.persons.iterator();
        while (persons.hasNext()) {
            if (persons.next().getEducation() == edu) {
                persons.remove();
            }
        }
    }
}
