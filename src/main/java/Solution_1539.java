package main.java;

public class Solution_1539 {
    public int findKthPositive(int[] arr, int k) {
        for (int n : arr) if (n <= k) k++;
        return k;
    }
}
