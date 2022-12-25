package main.java;

public class Solution_1406 {
    public String stoneGameIII(int[] stoneValue) {
        for (int i = stoneValue.length - 2; i >= 0; i--)
            stoneValue[i] += stoneValue[i + 1];
        int[] res = new int[stoneValue.length];
        for (int i = stoneValue.length - 1; i >= 0; i--)
            if (i == stoneValue.length - 1) res[i] = stoneValue[i];
            else if (i == stoneValue.length - 2) res[i] = stoneValue[i] - Math.min(0, res[i + 1]);
            else if (i == stoneValue.length - 3) res[i] = stoneValue[i] - Math.min(0, Math.min(res[i + 1], res[i + 2]));
            else res[i] = stoneValue[i] - Math.min(res[i + 3], Math.min(res[i + 1], res[i + 2]));
        int bob = stoneValue[0] - res[0];
        return bob == res[0] ? "Tie" : bob > res[0] ? "Bob" : "Alice";
    }
}
