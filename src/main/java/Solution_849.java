package main.java;

public class Solution_849 {
    public int maxDistToClosest(int[] seats) {
        int res = 1, preOne = -1;
        for (int i = 0; i < seats.length; i++)
            if (seats[i] == 1) {
                res = preOne == -1 ? Math.max(res, i) : Math.max(res, (i - preOne) / 2);
                preOne = i;
            }
        return Math.max(res, seats.length - 1 - preOne);
    }
}
