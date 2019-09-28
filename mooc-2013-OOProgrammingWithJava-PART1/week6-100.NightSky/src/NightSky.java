
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author davido
 */
public class NightSky {
    
    private double density;
    private int width;
    private int height;
    private int stars = 0;
    
    private static final int DEFAULT_WIDTH = 20;
    private static final int DEFAULT_HEIGHT = 10;
    private static final double DEFAULT_DENSITY = 0.1;
    
    public NightSky(double density) {
        this(density, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
    
    public NightSky(int width, int height) {
        this(DEFAULT_DENSITY, width, height);
    }
    
    public NightSky(double density, int width, int height) {
        this.density = density;
        this.width = width;
        this.height = height;
    }
    
    public void printLine() {
        Random random = new Random();
        for (int i = 0; i < this.width; i++) {
            if (random.nextDouble() < this.density) {
                System.out.print("*");
                this.stars++;
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    
    public void print() {
        this.stars = 0;
        for (int i = 0; i < this.height; i++) {
            this.printLine();
        }
    }
    
    public int starsInLastPrint() {
        return this.stars;
    }
}
