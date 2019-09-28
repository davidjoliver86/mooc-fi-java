
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author davido
 */
public class BirdDatabase {
    
    private ArrayList<Bird> birds;
    
    public BirdDatabase() {
        this.birds = new ArrayList<Bird>();
    }
    
    private Bird getBird(String birdName) {
        for (Bird bird : this.birds) {
            if (bird.getName().equals(birdName)) {
                return bird;
            }
        }
        System.out.println("Is not a bird!");
        return null;
    }
    
    public void add(String birdName, String latinName) {
        this.birds.add(new Bird(birdName, latinName));
    }
    
    public void observe(String birdName) {
        Bird bird = this.getBird(birdName);
        if (bird != null) {
            bird.observe();
        }
    }
    
    public void show(String birdName) {
        Bird bird = this.getBird(birdName);
        if (bird != null) {
            System.out.println(bird);
        }
    }
    
    public void statistics() {
        for (Bird bird : this.birds) {
            System.out.println(bird);
        }
    }
    
}
