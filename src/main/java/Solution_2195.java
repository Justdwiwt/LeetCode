package main.java;

import java.util.Arrays;

public class Solution_2195 {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0, tmp = 1, len = nums.length, cnt;
        for (int num : nums) {
            if (tmp < num) {
                cnt = num - tmp <= k ? num - tmp : k;
                sum += (2 * tmp + cnt - 1) * cnt / 2;
                k -= cnt;
                if (k == 0) return sum;
            }
            tmp = num + 1;
        }
        sum += (long) (nums[(int) (len - 1)] + 1 + nums[(int) (len - 1)] + k) * k / 2;
        return sum;
    }
}
