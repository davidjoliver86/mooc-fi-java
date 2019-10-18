
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Suitcase {
    private int weightLimit;
    private ArrayList<Thing> things;
    
    public Suitcase(int weightLimit) {
        this.weightLimit = weightLimit;
        this.things = new ArrayList<Thing>();
    }
    
    public void addThing(Thing thing) {
        if (this.totalWeight() + thing.getWeight() <= this.weightLimit) {
            this.things.add(thing);
        }
    }
    
    @Override
    public String toString() {
        String numThings;
        switch (things.size()) {
            case 0:
                numThings = "empty";
                break;
            case 1:
                numThings = "1 thing";
                break;
            default:
                numThings = String.format("%d things", things.size());
        }
        return String.format("%s (%d kg))", numThings, this.totalWeight());
    }

    public void printThings() {
        for (Thing thing : things) {
            System.out.println(thing);
        }
    }

    public int totalWeight() {
        int total = 0;
        for (Thing thing : things) {
            total += thing.getWeight();
        }
        return total;
    }

    public Thing heaviestThing() {
        if (this.things.isEmpty()) {
            return null;
        }
        Thing heaviest = this.things.get(0);
        for (int i = 1; i < this.things.size(); i++) {
            Thing thisThing = this.things.get(i);
            if (thisThing.getWeight() > heaviest.getWeight()) {
                heaviest = thisThing;
            }
        }
        return heaviest;
    }
}
