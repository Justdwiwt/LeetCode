package main.java;

import java.util.Arrays;

public class Solution_950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        int pointer = 1, idx = 0, N = deck.length;
        int[] res = new int[N];
        Arrays.sort(deck);
        for (int j : deck) {
            while (pointer < 2)
                pointer += res[(idx++) % N] == 0 ? 1 : 0;
            res[(idx - 1) % N] = j;
            pointer = 0;
        }
        return res;
    }
}
