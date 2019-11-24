/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author davido
 */
public class Farm implements Alive {
    
    private String owner;
    private Barn barn;
    private Collection<Cow> cows;
    
    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.cows = new ArrayList<Cow>();
    }
    
    public String getOwner() {
        return this.owner;
    }

    @Override
    public void liveHour() {
        for (Cow cow : cows) {
            cow.liveHour();
        }
    }
    
    public void manageCows() {
        this.barn.takeCareOf(cows);
    }
    
    @Override
    public String toString() {
        String cowReport;
        if (cows.isEmpty()) {
            cowReport = "No cows.";
        }
        else {
            cowReport = "Animals:";
            for (Cow cow : cows) {
                cowReport += String.format("\n        %s", cow);
            }
        }
        return String.format("Barn owner: %s\nBarn bulk tank: %s\n%s", this.owner, this.barn, cowReport);
    }

    public void addCow(Cow cow) {
        cows.add(cow);
    }

    public void installMilkingRobot(MilkingRobot robot) {
        this.barn.installMilkingRobot(robot);
    }
    
}
