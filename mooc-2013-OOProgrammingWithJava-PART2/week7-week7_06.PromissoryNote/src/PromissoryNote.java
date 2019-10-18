
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class PromissoryNote {
    
    private HashMap<String, Double> loans;
    
    public PromissoryNote() {
        this.loans = new HashMap<String, Double>();
    }

    public void setLoan(String name, double d) {
        this.loans.put(name, d);
    }

    public double howMuchIsTheDebt(String who) {
        if (this.loans.containsKey(who)) {
            return this.loans.get(who);
        }
        return 0.0;
    }
}
