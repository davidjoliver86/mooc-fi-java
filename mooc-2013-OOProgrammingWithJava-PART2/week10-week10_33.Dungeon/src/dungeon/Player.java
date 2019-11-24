/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author davido
 */
public class Player extends Entity {

    public Player() {
        this.point = new Point(0, 0);
    }

    public String getRepresentation() {
        return "@";
    }
}
