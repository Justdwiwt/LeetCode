package main.java;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_1024 {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, Comparator.comparingInt(o -> o[0]));
        int res = 0;
        int r = 0;
        while (r < T) {
            int tmp = r;
            for (int i = 0; i < clips.length && clips[i][0] <= r; i++) tmp = Math.max(tmp, clips[i][1]);
            if (tmp == r) return -1;
            r = tmp;
            res++;
        }
        return res;
    }
}
