/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Random;

/**
 *
 * @author davido
 */
public enum Direction {
    UP, DOWN, LEFT, RIGHT;
    
    public static Direction random() {
        int count = Direction.values().length;
        return Direction.values()[new Random().nextInt(count)];
    }
}
