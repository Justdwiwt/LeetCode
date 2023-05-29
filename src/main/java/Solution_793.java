package main.java;

public class Solution_793 {
    public int preimageSizeFZF(int k) {
        for (int i = 5, j = 1; i <= k; i += 6, j++) {
            int t = j;
            if (i == k) return 0;
            while (t % 5 == 0) {
                t /= 5;
                i++;
                if (i == k) return 0;
            }
        }
        return 5;
    }
}
