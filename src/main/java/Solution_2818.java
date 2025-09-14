package main.java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2818 {
    private static final int MAXN = (int) 1e5 + 10, MOD = (int) 1e9 + 7;

    private static final int[] cnt = new int[MAXN];
    private static final int[] left = new int[MAXN];
    private static final int[] right = new int[MAXN];

    static {
        for (int i = 2; i < MAXN; i++) {
            if (cnt[i] > 0) continue;
            for (int j = i; j < MAXN; j += i) {
                cnt[j]++;
            }
        }
    }

    private long qpow(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) ans = ans * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return ans % MOD;
    }

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();

        Arrays.fill(right, 0, n, n);
        Deque<Integer> sta = new ArrayDeque<>();
        sta.push(-1);
        for (int i = 0; i < n; i++) {
            Integer num = nums.get(i);
            while (sta.size() > 1 && cnt[nums.get(sta.peek())] < cnt[num]) right[sta.pop()] = i;
            left[i] = sta.peek();
            sta.push(i);
        }

        long ans = 1;
        List<Integer> ids = IntStream.range(0, n).boxed().sorted((o1, o2) -> Integer.compare(nums.get(o2), nums.get(o1))).collect(Collectors.toList());
        for (Integer id : ids) {
            if (k == 0) break;
            Integer x = nums.get(id);
            long min = Math.min((long) (id - left[id]) * (right[id] - id), k);
            ans = ans * qpow(x, min) % MOD;
            k -= min;
        }

        return (int) ans;
    }
}
