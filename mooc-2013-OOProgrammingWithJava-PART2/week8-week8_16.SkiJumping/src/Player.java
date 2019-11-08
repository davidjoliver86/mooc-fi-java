
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author davido
 */
class Player implements Comparable<Player> {
    private final String name;
    private final ArrayList<Integer> scores;
    private final ArrayList<Integer> jumps;
    
    public Player(String name) {
        this.name = name;
        this.scores = new ArrayList<Integer>();
        this.jumps = new ArrayList<Integer>();
    }
    
    public String getName() {
        return this.name;
    }
    
    public ArrayList<Integer> getJumps() {
        return this.jumps;
    }
    
    public void addScore(int score) {
        this.scores.add(score);
    }
    
    public void addJump(int jump) {
        this.jumps.add(jump);
    }
    
    public int totalScore() {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }

    @Override
    public int compareTo(Player t) {
        return this.totalScore() - t.totalScore();
    }
}
