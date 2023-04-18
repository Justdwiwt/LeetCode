package main.java;

public class Solution_915 {
    public int partitionDisjoint(int[] A) {
        if (A == null || A.length == 0) return 0;
        int leftMax = A[0];
        int max = A[0];
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            if (A[i] < leftMax) {
                leftMax = max;
                index = i;
            }
        }
        return index + 1;
    }
}
