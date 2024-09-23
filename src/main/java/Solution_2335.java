package main.java;

public class Solution_2335 {
    public int fillCups(int[] amount) {
        int max = Math.max(amount[0], Math.max(amount[1], amount[2]));
        int total = amount[0] + amount[1] + amount[2];
        return total <= 2 * max ? max : (total + 1) / 2;
    }
}
