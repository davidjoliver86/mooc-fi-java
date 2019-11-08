/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

/**
 *
 * @author davido
 */
public class Item implements Thing, Comparable<Item> {
    
    private String name;
    private int volume;
    
    public Item(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%d dm^3)", this.name, this.volume);
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    @Override
    public int compareTo(Item t) {
        return this.volume - t.volume;
    }
    
}
