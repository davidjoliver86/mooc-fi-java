/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author davido
 */
public class LyyraCard {
    
    private double balance;
    
    public LyyraCard(double startingBalance) {
        this.balance = startingBalance;
    }
    
    public String toString() {
        return String.format("The card has %.1f euros", this.balance);
    }
    
    private void pay(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        }
    }
    
    public void payEconomical() {
        pay(2.50);
    }
    
    public void payGourmet() {
        pay(4.0);
    }
    
    public void loadMoney(double amount) {
        if (amount >= 0.0) {
            this.balance += amount;
        }
        if (this.balance > 150.0) {
            this.balance = 150.0;
        }
    }
    
}
