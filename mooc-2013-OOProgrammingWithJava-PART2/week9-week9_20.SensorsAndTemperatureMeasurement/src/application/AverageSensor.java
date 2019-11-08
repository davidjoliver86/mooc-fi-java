/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author davido
 */
public class AverageSensor implements Sensor {
    
    private List<Sensor> sensors;
    private List<Integer> readings;
    
    public AverageSensor() {
        this.sensors = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }
    
    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : this.sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void on() {
        for (Sensor sensor : this.sensors) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor : this.sensors) {
            sensor.off();
        }
    }

    @Override
    public int measure() {
        if (!this.isOn() || this.sensors.size() == 0) {
            throw new IllegalStateException("dumbass");
        }
        int sum = 0;
        for (Sensor sensor : this.sensors) {
            int measurement = sensor.measure();
            sum += measurement;
        }
        int total = sum / this.sensors.size();
        this.readings.add(total);
        return total;
    }

    public List<Integer> readings() {
        return readings;
    }
}
