/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author davido
 */
public class Purchase {
    private final String product;
    private int amount;
    private final int unitPrice;

    public Purchase(String product, int amount, int unitPrice) {
        this.product = product;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }
    
    public int price() {
        return this.amount * this.unitPrice;
    }
    
    public String getProduct() {
        return this.product;
    }
    
    public void increaseAmount() {
        this.amount++;
    }
    
    @Override
    public String toString() {
        return String.format("%s: %d", this.product, this.amount);
    }
}
