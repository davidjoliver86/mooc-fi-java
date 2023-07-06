/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.LinkedList;
import java.util.List;
import wormgame.Direction;

/**
 *
 * @author davido
 */
public class Worm {
    
    private static final int INITIAL_LENGTH_CAP = 3;

    private int x;
    private int y;
    private Direction direction;
    private int lengthCap;
    private List<Piece> pieces;
    
    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.x = originalX;
        this.y = originalY;
        this.direction = originalDirection;
        this.lengthCap = INITIAL_LENGTH_CAP;
        this.pieces = new LinkedList<Piece>();
        this.pieces.add(new Piece(originalX, originalY));
    }
    
    public Direction getDirection() {
        return this.direction;
    }
    
    public void setDirection(Direction dir) {
        this.direction = dir;
    }
    
    public int getLength() {
        return this.pieces.size();
    }
    
    public List<Piece> getPieces() {
        return this.pieces;
    }

    public void move() {
        // update x, y based on direction
        switch(this.direction) {
            case UP:
                this.y -= 1;
                break;
            case DOWN:
                this.y += 1;
                break;
            case LEFT:
                this.x -= 1;
                break;
            case RIGHT:
                this.x += 1;
                break;
        }
        
        // create piece at current x, y
        this.pieces.add(new Piece(x, y));
        
        // if we went too far, snip off the first piece
        if (this.getPieces().size() > this.lengthCap) {
            this.pieces.remove(0);
        }
    }
    
    public void grow() {
        if (this.getPieces().size() == this.lengthCap) {
            this.lengthCap += 1;
        }
    }
    
    public boolean runsInto(Piece other) {
        for (Piece piece : this.pieces) {
            if (piece.runsInto(other)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean runsIntoItself() {
        // head piece index is the size of the worm - 1
        // check every piece before that - e.g. size of the worm - 2
        
        List<Piece> pieces = getPieces();
        Piece head = pieces.get(pieces.size() - 1);
        for (int i = 0; i < pieces.size() - 2; i++) {
            Piece piece = pieces.get(i);
            if (head.runsInto(piece)) {
                return true;
            }
        }
        return false;
    }
    
}
