/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author davido
 */
public class BulkTank {
    
    private final double DEFAULT_CAPACITY = 2000.0;

    private double capacity;
    private double volume = 0.0;

    public BulkTank(double capacity) {
        this.capacity = capacity;
    }
    
    public BulkTank() {
        this.capacity = DEFAULT_CAPACITY;
    }
    
    public double getCapacity() {
        return this.capacity;
    }
    
    public double getVolume() {
        return this.volume;
    }
    
    public double howMuchFreeSpace() {
        return this.getCapacity() - this.getVolume();
    }
    
    public void addToTank(double amount) {
        double newVolume = this.getVolume() + amount;
        this.volume = Math.min(newVolume, this.getCapacity());
    }
    
    public double getFromTank(double amount) {
        double taken = Math.min(amount, this.getVolume());
        this.volume = Math.max(0.0, this.getVolume() - taken);
        return taken;
    }
    
    @Override
    public String toString() {
        return String.format("%.1f/%.1f", Math.ceil(this.getVolume()), Math.ceil(this.getCapacity()));
    }
}
