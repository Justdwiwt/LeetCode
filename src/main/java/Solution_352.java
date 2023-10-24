package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_352 {
    static class SummaryRanges {
        int[] nums = new int[10001];
        int max = 0;

        public SummaryRanges() {
        }

        public void addNum(int val) {
            if (nums[val] == 0) nums[val] = val + 1;
            max = Math.max(max, val);
        }

        public int[][] getIntervals() {
            List<int[]> res = new ArrayList<>();
            for (int i = 0; i <= max; i++)
                if (nums[i] != 0) {
                    int j = find(nums[i]) - 1;
                    res.add(new int[]{i, j});
                    i = j;
                }
            return res.toArray(new int[0][2]);
        }

        private int find(int x) {
            return nums[x] == 0 ? x : (nums[x] = find(nums[x]));
        }
    }
}
