/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author davido
 */
public class Thermometer implements Sensor {
    
    private boolean on;
    private Random randomizer;
    
    public Thermometer() {
        this.on = false;
        this.randomizer = new Random();
    }

    @Override
    public boolean isOn() {
        return this.on;
    }

    @Override
    public void on() {
        this.on = true;
    }

    @Override
    public void off() {
        this.on = false;
    }

    @Override
    public int measure() {
        if (!isOn()) {
            throw new IllegalStateException();
        }
        return this.randomizer.nextInt(61) - 30;
    }
}
