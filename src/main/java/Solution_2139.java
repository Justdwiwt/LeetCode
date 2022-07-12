package main.java;

public class Solution_2139 {
    public int minMoves(int target, int maxDoubles) {
        if (maxDoubles == 0 || target == 1) return target - 1;
        if (target % 2 == 0) return minMoves(target / 2, maxDoubles - 1) + 1;
        return minMoves((target - 1) / 2, maxDoubles - 1) + 2;
    }
}
