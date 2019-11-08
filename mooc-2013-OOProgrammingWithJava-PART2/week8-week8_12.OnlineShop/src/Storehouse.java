
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author davido
 */
public class Storehouse {

    private Map<String, Integer> prices;
    private Map<String, Integer> stocks;

    public Storehouse() {
        this.prices = new HashMap<String, Integer>();
        this.stocks = new HashMap<String, Integer>();
    }

    public void addProduct(String product, int price, int stock) {
        this.prices.put(product, price);
        this.stocks.put(product, stock);
    }

    public boolean take(String product) {
        if (!stocks.containsKey(product)) {
            return false;
        }
        int quantity = this.stocks.get(product);
        if (quantity == 0) {
            return false;
        }
        this.stocks.put(product, quantity - 1);
        return true;
    }

    public int price(String product) {
        if (!prices.containsKey(product)) {
            return -99;
        }
        return prices.get(product);
    }

    public int stock(String product) {
        if (!stocks.containsKey(product)) {
            return 0;
        }
        return stocks.get(product);
    }

    public Set<String> products() {
        return this.stocks.keySet();
    }
}
