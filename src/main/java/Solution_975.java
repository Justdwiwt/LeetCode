package main.java;

import java.util.TreeMap;

public class Solution_975 {
    public int oddEvenJumps(int[] arr) {
        int N = arr.length;
        byte[] dp = new byte[N];
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        dp[N - 1] = 3;
        tm.put(arr[N - 1], N - 1);
        int sum = 1;
        for (int i = N - 2; i >= 0; i--) {
            Integer j;
            if ((j = tm.ceilingKey(arr[i])) != null && dp[tm.get(j)] >= 2) {
                dp[i] = 1;
                sum++;
            }
            if ((j = tm.floorKey(arr[i])) != null && ((j = tm.get(j)) == N - 1 || dp[j] == 1 || dp[j] == 3)) dp[i] += 2;
            tm.put(arr[i], i);
        }
        return sum;
    }
}
