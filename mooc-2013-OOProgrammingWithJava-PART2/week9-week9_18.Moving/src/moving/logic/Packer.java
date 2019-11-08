/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.logic;

import java.util.ArrayList;
import java.util.List;
import moving.domain.Box;
import moving.domain.Thing;

/**
 *
 * @author davido
 */
public class Packer {
    
    private final int BOX_CAPACITY;

    public Packer(int boxesVolume) {
        this.BOX_CAPACITY = boxesVolume;
    }

    public List<Box> packThings(List<Thing> things) {
        List<Box> boxes = new ArrayList<Box>();

        boxes.add(new Box(BOX_CAPACITY));
        for (Thing thing : things) {
            boolean found = false;
            for (Box box : boxes) {
                found = box.addThing(thing);
                if (found) {
                    break;
                }
            }
            if (!found) {
                Box newBox = new Box(BOX_CAPACITY);
                newBox.addThing(thing);
                boxes.add(newBox);
            }
        }
        return boxes;
    }
    
}
