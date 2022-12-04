package main.java;

public class Solution_1492 {
    public int kthFactor(int n, int k) {
        int i, j;
        int[] arr = new int[n / 2 + 1];
        for (i = 1, j = 0; i <= n / 2; i++)
            if (n % i == 0) arr[j++] = i;
        arr[j++] = n;
        return j < k ? -1 : arr[k - 1];
    }
}
