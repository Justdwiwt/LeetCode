package main.java;

public class Solution_1739 {
    public int minimumBoxes(int n) {
        int cur = 1, depth = 1, sum = 1;
        while (sum < n) {
            depth++;
            cur += depth;
            sum += cur;
        }
        while (sum > n) {
            int min = Math.min(sum - n, depth);
            sum -= min;
            if (min == depth) {
                cur--;
                depth--;
            }
        }
        return cur;
    }
}
