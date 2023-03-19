package main.java;

public class Solution_1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        int[] arr = new int[60];
        for (int t : time) {
            res += arr[(60 - t % 60) % 60];
            arr[t % 60]++;
        }
        return res;
    }
}
