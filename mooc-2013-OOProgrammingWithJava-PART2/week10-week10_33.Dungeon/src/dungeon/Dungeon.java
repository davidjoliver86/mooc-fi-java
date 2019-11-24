/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author davido
 */
public class Dungeon {

    private final int length;
    private final int height;
    private int moves;
    private boolean vampiresMove;

    // entities
    private final Player player;
    private List<Vampire> vampires;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.player = new Player();
        this.createVampires(vampires);
    }

    private void createVampires(int numVampires) {
        this.vampires = new ArrayList<Vampire>();
        for (int i = 0; i < numVampires; i++) {
            Vampire newVampire = new Vampire(length, height);
            boolean tryAgain;
            do {
                tryAgain = false;
                // Spawned at 0,0? Try again.
                if (this.player.getPoint().equals(newVampire.getPoint())) {
                    tryAgain = true;
                } // Collided with an existing vampire? Try again.
                else {
                    for (Vampire existing : this.vampires) {
                        if (newVampire.getPoint().equals(existing.getPoint())) {
                            tryAgain = true;
                            break;
                        }
                    }
                }
                if (tryAgain) {
                    newVampire.teleport();
                }
            } while (tryAgain);
            this.vampires.add(newVampire);
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        List<Character> moveBuffer = new LinkedList<Character>();
        while (moves > 0) {
            if (vampires.isEmpty()) {
                System.out.println("YOU WIN");
                return;
            }
            if (moveBuffer.isEmpty()) {
                printStatus();
                moveBuffer = getPlayerMoves(scanner, moveBuffer);
                moves--;
            }
            playersTurn(moveBuffer.get(0));
            moveBuffer.remove(0);
            if (vampiresMove) {
                vampiresTurn();
            }
        }
        System.out.println("YOU LOSE");
    }

    private List<Character> getPlayerMoves(Scanner scanner, List<Character> moveBuffer) {
        String steps = scanner.nextLine();
        for (char ch : steps.toCharArray()) {
            if (ch == 'w' || ch == 'a' || ch == 's' || ch == 'd') {
                moveBuffer.add(ch);
            }
        }
        return moveBuffer;
    }

    public void debug() {
        System.out.println(vampires);
        for (Vampire a : vampires) {
            for (Vampire b : vampires) {
                System.out.printf("%s ", a == b);
            }
            System.out.println();
        }
    }

    private boolean validateMove(Point p) {
        if (p.getX() < 0) {
            return false;
        }
        if (p.getX() >= length) {
            return false;
        }
        if (p.getY() < 0) {
            return false;
        }
        return p.getY() < height;
    }

    private boolean playersTurn(char c) {
        // Get input from player.
        Point p = null;
        switch (c) {
            case 'w':
                p = player.proposeMove(Direction.UP);
                break;
            case 'a':
                p = player.proposeMove(Direction.LEFT);
                break;
            case 's':
                p = player.proposeMove(Direction.DOWN);
                break;
            case 'd':
                p = player.proposeMove(Direction.RIGHT);
                break;
            default:
                return false;
        }

        // Can't move out of the dungeon.
        if (!validateMove(p)) {
            return false;
        }

        // Valid move; set point.
        player.setPoint(p);

        // Check if you hit a vampire.
        Vampire dead = null;
        for (Vampire vampire : vampires) {
            if (vampire.getPoint().equals(p)) {
                dead = vampire;
            }
        }

        // Kill that son of a bitch.
        if (dead != null) {
            vampires.remove(dead);
        }
        return true;
    }

    private void vampiresTurn() {
        List<Vampire> dead = new LinkedList<Vampire>();
        for (Vampire vampire : vampires) {
            Point p = vampire.proposeMove(Direction.random());

            // If collides with other vampires, don't move.
            for (Vampire other : vampires) {
                if (p.equals(other.getPoint())) {
                    break;
                }
            }

            // Can't move out of the dungeon.
            if (!validateMove(p)) {
                break;
            }

            // If collides with player, dead.
            if (p.equals(player.getPoint())) {
                dead.add(vampire);
                break;
            }

            // Valid move; set point.
            vampire.setPoint(p);
        }

        // Purge the dead.
        for (Vampire deadVampire : dead) {
            vampires.remove(deadVampire);
        }
    }

    private void printStatus() {
        System.out.println(moves);
        System.out.println();
        System.out.println(player);
        for (Vampire v : vampires) {
            System.out.println(v);
        }
        System.out.println();

        // Draw dungeon - first get a set of points.
        Set<Point> vampirePoints = new HashSet<Point>();
        for (Vampire vampire : vampires) {
            vampirePoints.add(vampire.getPoint());
        }
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < length; column++) {
                Point p = new Point(column, row);
                if (p.equals(player.getPoint())) {
                    System.out.print("@");
                } else if (vampirePoints.contains(p)) {
                    System.out.print("v");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
