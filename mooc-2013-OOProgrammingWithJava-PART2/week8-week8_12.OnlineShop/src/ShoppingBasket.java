
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author davido
 */
public class ShoppingBasket {
    
    private final List<Purchase> purchases;
    
    public ShoppingBasket() {
        this.purchases = new ArrayList<Purchase>();
    }

    public void add(String product, int price) {
        for (Purchase purchase : this.purchases) {
            if (product.equals(purchase.getProduct())) {
                purchase.increaseAmount();
                return;
            }
        }
        this.purchases.add(new Purchase(product, 1, price));
    }
    
    public int price() {
        int total = 0;
        for (Purchase purchase : this.purchases) {
            total += purchase.price();
        }
        return total;
    }

    public void print() {
        for (Purchase purchase : this.purchases) {
            System.out.println(purchase);
        }
    }
    
}
