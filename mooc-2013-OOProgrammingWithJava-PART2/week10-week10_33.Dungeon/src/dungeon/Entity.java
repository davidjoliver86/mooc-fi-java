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
public abstract class Entity {

    public static final Random randomizer = new Random();

    protected Point point;

    public Point getPoint() {
        return this.point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Point proposeMove(Direction direction) {
        // Moves one space up/down/left/right. Returns a Point of a *proposed* move in that direction.
        // It's up to the game logic (in Dungeon) to determine if that move is actually valid.
        // To *actually* move, call setPoint with the Point that this method returns.
        switch(direction) {
            case UP:
                return new Point(this.point.getX(), this.point.getY() - 1);
            case DOWN:
                return new Point(this.point.getX(), this.point.getY() + 1);
            case LEFT:
                return new Point(this.point.getX() - 1, this.point.getY());
            case RIGHT:
                return new Point(this.point.getX() + 1, this.point.getY());
            // should never happen
            default:
                return null;
        }
    }
    
    public abstract String getRepresentation();
    
    @Override
    public String toString() {
        return String.format("%s %d %d", this.getRepresentation(), this.point.getX(), this.point.getY());
    }
}
