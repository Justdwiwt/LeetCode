package main.java;

public class Solution_1224 {
    final int N = 100010;

    public int maxEqualFreq(int[] nums) {
        int[] cnt = new int[N], sum = new int[N];
        int max = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[cnt[nums[i]]++]--;
            sum[cnt[nums[i]]]++;
            max = Math.max(cnt[nums[i]], max);
            if (max == 1) res = i + 1;
            if (max * sum[max] + 1 == i + 1) res = i + 1;
            if ((max - 1) * sum[max - 1] + max == i + 1) res = i + 1;
        }
        return res;
    }
}
