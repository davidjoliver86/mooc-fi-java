/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author davido
 */
public class ProductContainerRecorder extends ProductContainer {
    
    private ContainerHistory history;
    
    public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
        super(productName, capacity);
        this.history = new ContainerHistory();
        this.addToTheContainer(initialVolume);
    }

    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount); //To change body of generated methods, choose Tools | Templates.
        this.history.add(this.getVolume());
    }

    @Override
    public double takeFromTheContainer(double amount) {
        double taken = super.takeFromTheContainer(amount); //To change body of generated methods, choose Tools | Templates.
        this.history.add(this.getVolume());
        return taken;
    }
    
    public String history() {
        return this.history.toString();
    }
    
    public void printAnalysis() {
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + this.history());
        System.out.println("Greatest product amount: " + this.history.maxValue());
        System.out.println("Smallest product amount: " + this.history.minValue());
        System.out.println("Average: " + this.history.average());
        System.out.println("Greatest change: " + this.history.greatestFluctuation());
        System.out.println("Variance: " + this.history.variance());
    }
}
