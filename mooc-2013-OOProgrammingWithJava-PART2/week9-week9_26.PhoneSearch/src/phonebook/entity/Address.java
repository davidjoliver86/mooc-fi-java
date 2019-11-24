/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook.entity;

/**
 *
 * @author davido
 */
public class Address implements PersonalInfo {
    private String street;
    private String city;
    
    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
    
    public String get() {
        return String.format("%s %s", this.street, this.city);
    }
    
    public String toString() {
        return get();
    }
}
