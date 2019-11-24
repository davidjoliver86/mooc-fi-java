/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Random;

/**
 *
 * @author davido
 */
public class Cow implements Milkable, Alive {

    private static final int MIN_CAPACITY = 15;
    private static final int MAX_CAPACITY = 40;
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    private String name;
    private double capacity;
    private double amount = 0.0;

    private String getRandomName() {
        return NAMES[new Random().nextInt(NAMES.length)];
    }

    private double getRandomCapacity() {
        return MIN_CAPACITY + new Random().nextInt(MAX_CAPACITY - MIN_CAPACITY + 1);
    }

    public Cow(String name) {
        this.name = name;
        this.capacity = getRandomCapacity();
    }

    public Cow() {
        this.name = getRandomName();
        this.capacity = getRandomCapacity();
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getCapacity() {
        return this.capacity;
    }
    
    public double getAmount() {
        return this.amount;
    }

    @Override
    public double milk() {
        double amount = getAmount();
        this.amount = 0.0;
        return amount;
    }

    @Override
    public void liveHour() {
        double milkProduced = 0.7 + new Random().nextDouble() * 1.3;
        double newAmount = getAmount() + milkProduced;
        this.amount = Math.min(getCapacity(), newAmount);
    }
    
    @Override
    public String toString() {
        return String.format("%s %.1f/%.1f", getName(), Math.ceil(getAmount()), Math.ceil(getCapacity()));
    }

}
