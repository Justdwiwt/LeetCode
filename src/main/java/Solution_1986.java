package main.java;

public class Solution_1986 {
    public int minSessions(int[] tasks, int sessionTime) {
        int max = 1 << tasks.length;
        boolean[] latestSession = new boolean[max];
        for (int i = 1; i < max; i++) {
            int sum = 0;
            for (int j = 0; j < tasks.length; j++)
                if ((i & (1 << j)) != 0)
                    sum += tasks[j];
            latestSession[i] = sum <= sessionTime;
        }
        int[] res = new int[max];
        for (int i = 1; i < max; i++) {
            res[i] = tasks.length;
            for (int j = i; j > 0; j = ((j - 1) & i))
                if (latestSession[j])
                    res[i] = Math.min(res[i], res[j ^ i] + 1);
        }
        return res[max - 1];
    }
}
