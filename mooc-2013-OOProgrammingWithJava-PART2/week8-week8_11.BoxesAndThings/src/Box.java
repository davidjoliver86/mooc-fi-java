
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
public class Box implements ToBeStored {

    private final double maxWeight;
    private ArrayList<ToBeStored> things;
    
    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<ToBeStored>();
    }
    
    public void add(ToBeStored newThing) {
        if (this.weight() + newThing.weight() <= maxWeight) {
            things.add(newThing);
        }
    }
    
    public double weight() {
        double total = 0.0;
        for (ToBeStored thing : things) {
            total += thing.weight();
        }
        return total;
    }

    @Override
    public String toString() {
        return String.format("Box: %d things, total weight %.1f kg", things.size(), this.weight());
    }
}
