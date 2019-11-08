
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author davido
 */
class Tournament {

    private List<Player> players;
    private Scanner scanner;
    private Random randomizer;
    
    private final int MIN_LENGTH = 60;
    private final int LENGTH_VARIABLE = 61;
    private final int NUM_JUDGES = 5;
    private final int MIN_SCORE = 10;
    private final int SCORE_VARIABLE = 11;

    public Tournament(Scanner scanner) {
        this.players = new ArrayList<Player>();
        this.scanner = scanner;
        this.randomizer = new Random();
    }

    void run() {
        getNames();
        play();
        printResults();
    }

    private void getNames() {
        System.out.println("Kumpula ski jumping week\n"
                + "\n"
                + "Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        while (true) {
            System.out.print("  Participant name: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                return;
            }
            this.players.add(new Player(name));
        }
    }

    private void play() {
        int round = 1;
        System.out.println("The tournament begins!");
        while (true) {
            System.out.print("\nWrite \"jump\" to jump; otherwise you quit: ");
            if ("jump".equals(scanner.nextLine())) {
                playRound(round);
                round++;
            } else {
                break;
            }
        }
    }
    
    private void playRound(int round) {
        System.out.println(String.format("Round %d\n", round));
        Collections.sort(players);
        System.out.println("Jumping order:");
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            System.out.printf("  %d. %s (%d points)\n", i+1, p.getName(), p.totalScore());
        }
        System.out.println(String.format("\nResults of round %d", round));
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            System.out.println("  " + p.getName());
            
            // get length
            int length = MIN_LENGTH + this.randomizer.nextInt(LENGTH_VARIABLE);
            System.out.println("    length: " + length);
            
            // get judge scores
            ArrayList<Integer> judgeScores = new ArrayList<Integer>();
            for (int j = 0; j < NUM_JUDGES; j++) {
                judgeScores.add(MIN_SCORE + this.randomizer.nextInt(SCORE_VARIABLE));
            }
            System.out.println("    judge votes: " + judgeScores);
            
            // sum up score (disregard highest and lowest judge)
            int score = length - Collections.max(judgeScores) - Collections.min(judgeScores);
            for (int judgeScore : judgeScores) {
                score += judgeScore;
            }
            p.addScore(score);
            p.addJump(length);
        }
    }

    private void printResults() {
        Collections.sort(players);
        Collections.reverse(players);
        System.out.println("Thanks!\n\nTournament results:\nPosition    Name");
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            ArrayList<Integer> jumps = p.getJumps();
            int numJumps = jumps.size();
            System.out.printf("%d           %s (%d points)\n", i+1, p.getName(), p.totalScore());
            System.out.printf("            jump lengths: ");
            for (int j = 0; j < numJumps; j++) {
                System.out.print(jumps.get(j) + " m");
                if (j + 1 < numJumps) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

}
