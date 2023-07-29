package main.java;

public class Solution_526 {
    public int countArrangement(int n) {
        boolean[] arr = new boolean[n + 1];
        return dfs(1, arr, n);
    }

    int dfs(int index, boolean[] arr, int n) {
        if (index > n) return 1;
        int count = 0;
        for (int i = 1; i <= n; i++)
            if (!arr[i] && (i % index == 0 || index % i == 0)) {
                arr[i] = true;
                count += dfs(index + 1, arr, n);
                arr[i] = false;
            }
        return count;
    }
}
