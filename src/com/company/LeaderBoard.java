package com.company;

import java.util.ArrayList;

public class LeaderBoard {
    private ArrayList<GameResult> leaders = new ArrayList<>();

    public void addLeader(GameResult gr) {
        leaders.add(gr);
    }

    public void printResults() {
        int maxLen = 0;
        for (GameResult r : leaders) {
            if (r.getName().length() > maxLen) {
                maxLen = r.getName().length();
            }
        }
        for (GameResult r : leaders) {
            System.out.printf("%-" + maxLen + "s %2d %3.2f%n", r.getName(), r.getTriesCount(), r.getTime() / 1000.0);
        }
    }

}
