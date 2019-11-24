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
public final class Vampire extends Entity {

    private final int maxLength;
    private final int maxHeight;

    public Vampire(int maxLength, int maxHeight) {
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
        this.teleport();
    }

    public void teleport() {
        int x = Vampire.randomizer.nextInt(maxLength);
        int y = Vampire.randomizer.nextInt(maxHeight);
        this.point = new Point(x, y);
    }

    public String getRepresentation() {
        return "v";
    }

}
