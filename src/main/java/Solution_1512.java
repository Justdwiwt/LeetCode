package main.java;

public class Solution_1512 {
    public int numIdenticalPairs(int[] nums) {
        int[] cnt = new int[101];
        int res = 0;
        for (int num : nums) {
            res += cnt[num];
            cnt[num]++;
        }
        return res;
    }
}
