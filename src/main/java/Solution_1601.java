package main.java;

import java.util.Arrays;

public class Solution_1601 {
    public int maximumRequests(int n, int[][] requests) {
        int m = requests.length;
        int max = 1 << m, res = 0;
        int[] ok = new int[n];
        for (int i = 1; i < max; i++) {
            int[] arr = new int[n];
            int state = i, idx = 0, cnt = 0;
            while (state > 0) {
                int bit = state & 1;
                if (bit == 1) {
                    int from = requests[idx][0];
                    int to = requests[idx][1];
                    arr[from]--;
                    arr[to]++;
                    cnt++;
                }
                state >>= 1;
                idx++;
            }
            if (Arrays.equals(arr, ok))
                res = Math.max(res, cnt);
        }
        return res;
    }
}
