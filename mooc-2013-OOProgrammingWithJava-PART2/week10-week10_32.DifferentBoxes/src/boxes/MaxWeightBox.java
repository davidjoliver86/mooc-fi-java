/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davido
 */
public class MaxWeightBox extends Box {

    private int maxWeight;
    private List<Thing> things;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        if (thing.getWeight() > this.maxWeight) {
            return;
        }
        int total = 0;
        for (Thing t : this.things) {
            total += t.getWeight();
        }
        if (total + thing.getWeight() > maxWeight) {
            return;
        }
        this.things.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        for (Thing t : this.things) {
            if (thing.equals(t)) {
                return true;
            }
        }
        return false;
    }
}
