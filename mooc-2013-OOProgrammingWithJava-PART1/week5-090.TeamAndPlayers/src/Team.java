
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
public class Team {

    private String name;
    private ArrayList<Player> players;
    private int maxSize;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<Player>();
        this.maxSize = 16;
    }
    
    @Override
    public String toString() {
        return "Team: " + name;
    }

    public String getName() {
        return name;
    }
    
    public int size() {
        return this.players.size();
    }
    
    public int goals() {
        int teamGoals = 0;
        for (Player p : players) {
            teamGoals += p.goals();
        }
        return teamGoals;
    }
    
    public void setMaxSize(int size) {
        this.maxSize = size;
    }
    
    public void addPlayer(Player player) {
        if (this.players.size() < this.maxSize) {
            this.players.add(player);
        }
    }
    
    public void printPlayers() {
        for (Player p : players) {
            System.out.println(p);
        }
    }
}
