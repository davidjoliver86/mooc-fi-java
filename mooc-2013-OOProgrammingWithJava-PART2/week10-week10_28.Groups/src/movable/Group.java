/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davido
 */
public class Group implements Movable {
    
    private final List<Movable> objects;
    
    public Group() {
        this.objects = new ArrayList<Movable>();
    }

    @Override
    public String toString() {
        String group = "";
        for (Movable object : objects) {
            group = group + object.toString() + "\n";
        }
        return group;
    }
    
    public void addToGroup(Movable movable) {
        this.objects.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable object : objects) {
            object.move(dx, dy);
        }
    }
    
}
