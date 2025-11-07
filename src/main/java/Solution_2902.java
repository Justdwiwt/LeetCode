package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_2902 {
    private static final int MAXN = (int) 2e4 + 10, MOD = (int) 1e9 + 7;

    private static int[] pre = new int[MAXN];
    private static int[] now = new int[MAXN];
    private static final int[] tmp = new int[MAXN];

    public int countSubMultisets(List<Integer> nums, int l, int r) {
        int s = 0, cnt0 = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums)
            if (num > 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                s += num;
            } else cnt0++;

        IntStream.rangeClosed(0, s).forEach(i -> pre[i] = now[i] = 0);
        pre[0] = 1;
        s = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), cnt = entry.getValue();
            s += num * cnt;
            IntStream.rangeClosed(0, s).forEach(j -> now[j] = tmp[j] = 0);
            IntStream.rangeClosed(0, s).forEach(j -> {
                tmp[j] = pre[j];
                if (j >= num) tmp[j] = (tmp[j] + tmp[j - num]) % MOD;
                now[j] = tmp[j];
                int real = Math.min(j / num, cnt);
                if (j - num * (real + 1) >= 0) {
                    now[j] = (now[j] - tmp[j - num * (real + 1)]) % MOD;
                    now[j] = (now[j] + MOD) % MOD;
                }
            });

            int[] mid = now;
            now = pre;
            pre = mid;
        }

        long ans = 0;
        r = Math.min(r, s);
        for (int j = l; j <= r; j++) ans = (ans + pre[j]) % MOD;
        ans = (ans + ans * cnt0 % MOD) % MOD;
        return (int) ans;
    }
}
