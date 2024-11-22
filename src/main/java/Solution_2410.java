package main.java;

import java.util.Arrays;

public class Solution_2410 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        if (players.length == 0 || trainers.length == 0) return 0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0;
        int j = 0;
        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) i++;
            j++;
        }
        return i;
    }
}
