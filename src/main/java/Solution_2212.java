package main.java;

public class Solution_2212 {
    public int[] maximumBobPoints(int num, int[] as) {
        int maxVal = 0, n = as.length;
        int[] res = new int[n];
        for (int i = 1; i < (1 << n); i++) {
            int tot = 0, score = 0;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    tot += as[j] + 1;
                    score += j;
                }
                if (tot > num) {
                    flag = false;
                    break;
                }
            }
            if (flag && score > maxVal) {
                maxVal = score;
                for (int j = 0; j < n; j++)
                    if (((i >> j) & 1) == 1)
                        res[j] = as[j] + 1;
                    else res[j] = 0;
                res[0] = num - tot;
            }
        }
        return res;
    }
}
