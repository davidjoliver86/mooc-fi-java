/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author davido
 */
public class CD implements ToBeStored {
    
    private final double WEIGHT = 0.1;

    private String artist;
    private String title;
    private int year;

    public CD(String artist, String title, int year) {
        this.artist = artist;
        this.title = title;
        this.year = year;
    }
    
    public String toString() {
        return String.format("%s: %s (%d)", artist, title, year);
    }
    
    public double weight() {
        return WEIGHT;
    }
}
