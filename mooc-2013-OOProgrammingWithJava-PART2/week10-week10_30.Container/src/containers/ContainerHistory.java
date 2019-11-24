/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davido
 */
public class ContainerHistory {

    private List<Double> history;

    public ContainerHistory() {
        this.history = new ArrayList<Double>();
    }

    public void add(double amount) {
        this.history.add(amount);
    }

    public void reset() {
        this.history.clear();
    }

    public String toString() {
        return this.history.toString();
    }

    public double maxValue() {
        int size = this.history.size();
        if (size == 0) {
            return 0.0;
        }
        double max = this.history.get(0);
        for (int i = 1; i < size; i++) {
            double hist = this.history.get(i);
            if (hist > max) {
                max = hist;
            }
        }
        return max;
    }
    
    public double minValue() {
        int size = this.history.size();
        if (size == 0) {
            return 0.0;
        }
        double min = this.history.get(0);
        for (int i = 1; i < size; i++) {
            double hist = this.history.get(i);
            if (hist < min) {
                min = hist;
            }
        }
        return min;
    }
    
    public double average() {
        int size = this.history.size();
        if (size == 0) {
            return 0.0;
        }
        double total = 0.0;
        for (int i = 0; i < size; i++) {
            total += this.history.get(i);
        }
        return total / size;
    }
    
    public double greatestFluctuation() {
        int size = this.history.size();
        double greatest = 0.0;
        if (size <= 1) {
            return greatest;
        }
        for (int i = 0; i < (size - 1); i++) {
            double flux = Math.abs(this.history.get(i) - this.history.get(i+1));
            if (flux > greatest) {
                greatest = flux;
            }
        }
        return greatest;
    }
    
    public double variance() {
        int size = this.history.size();
        if (size <= 1) {
            return 0.0;
        }
        double average = this.average();
        double deviations = 0.0;
        for (double d : this.history) {
            deviations += (d - average) * (d - average);
        }
        return deviations / (size - 1);
    }
}
