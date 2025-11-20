package main.java;

public class Solution_2917 {
    public int findKOr(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < 31; i++) {
            int cnt = 0;
            for (int n : nums) cnt += (n >> i) & 1;
            res |= cnt >= k ? (1 << i) : 0;
        }
        return res;
    }
}
