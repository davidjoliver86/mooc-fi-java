package models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author davido
 */
public class Calculator {
    
    private int value;
    
    public Calculator() {
        this.value = 0;
    }

    public int getValue() {
        return this.value;
    }
    
    public void add(int value) {
        this.value += value;
    }
    
    public void subtract(int value) {
        this.value -= value;
    }
    
    public void zero() {
        this.value = 0;
    }
}