/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author davido
 */
public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double prob) {
        Random random = new Random();
        boolean[][] board = this.getBoard();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = random.nextDouble() < prob;
            }
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        try {
            return this.getBoard()[x][y];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }

    @Override
    public void turnToLiving(int x, int y) {
        try {
            this.getBoard()[x][y] = true;
        } catch (ArrayIndexOutOfBoundsException ex) {
        }

    }

    @Override
    public void turnToDead(int x, int y) {
        try {
            this.getBoard()[x][y] = false;
        } catch (ArrayIndexOutOfBoundsException ex) {

        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int neighbors = 0;
        for (int dx = (x - 1); dx <= (x + 1); dx++) {
            for (int dy = (y - 1); dy <= (y + 1); dy++) {
                if (dx == x && dy == y) {
                    continue;
                }
                if (isAlive(dx, dy)) {
                    neighbors += 1;
                }
            }
        }
        return neighbors;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbors) {
        boolean alive = isAlive(x, y);
        // Every living cell dies if they have less than two living neighbours.
        if (alive && livingNeighbors < 2) {
            turnToDead(x, y);
        }
        // Every living cell keeps on living during the following iteration (i.e. turn) if they have two or three living neighbours.
        if (alive && (livingNeighbors == 2 || livingNeighbors == 3)) {
        }
        // Every living cell dies if they have more than three living neighbours.
        if (alive && livingNeighbors > 3) {
            turnToDead(x, y);
        }
        // Every dead cell is turned back to life if they have exactly three living neighbours.
        if (!alive && livingNeighbors == 3) {
            turnToLiving(x, y);
        }
    }

}
