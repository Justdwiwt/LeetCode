package main.java;

public class Solution_2522 {
    public int minimumPartition(String s, int k) {
        int res = 1;
        long sum = 0;
        for (char c : s.toCharArray()) {
            int value = c - '0';
            if (value > k) return -1;
            sum = sum * 10 + value;
            if (sum > k) {
                res++;
                sum = value;
            }
        }
        return res;
    }
}
