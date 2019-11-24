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
public class PhoneNumber implements PersonalInfo {
    private String number;
    
    public PhoneNumber(String number) {
        this.number = number;
    }
    
    public String get() {
        return this.number;
    }
    
    public String toString() {
        return get();
    }
}
