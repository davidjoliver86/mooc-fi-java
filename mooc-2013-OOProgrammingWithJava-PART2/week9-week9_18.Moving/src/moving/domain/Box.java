/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davido
 */
public class Box implements Thing {
    
    private int maximumCapacity;
    private List<Thing> things;
    
    public Box(int maximumCapcity) {
        this.maximumCapacity = maximumCapcity;
        this.things = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing) {
        if (this.getVolume() + thing.getVolume() <= this.maximumCapacity) {
            this.things.add(thing);
            return true;
        }
        return false;
    }

    @Override
    public int getVolume() {
        int total = 0;
        for (Thing thing : this.things) {
            total += thing.getVolume();
        }
        return total;
    }
    
    @Override
    public String toString() {
        return String.format("  things in the box: %d dm^3", this.getVolume());
    }
    
}
