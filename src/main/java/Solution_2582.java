package main.java;

public class Solution_2582 {
    public int passThePillow(int n, int time) {
        return time / (n - 1) % 2 == 0 ? time % (n - 1) + 1 : n - time % (n - 1);
    }
}
