package main.java;

import java.util.stream.IntStream;

public class Solution_307 {
    static class NumArray {

        int[] t;
        int[] nums;

        private int lowbits(int x) {
            return x & (-x);
        }

        private void add(int k, int v) {
            while (k < t.length) {
                t[k] += v;
                k += lowbits(k);
            }
        }

        public NumArray(int[] nums) {
            this.nums = nums;
            this.t = new int[nums.length + 1];
            IntStream.range(0, nums.length).forEach(i -> add(i + 1, nums[i]));
        }

        public void update(int index, int val) {
            int v = val - nums[index];
            nums[index] = val;
            add(index + 1, v);
        }

        public int sumRange(int left, int right) {
            int k = right + 1;
            int sum = 0;
            while (k > 0) {
                sum += t[k];
                k -= lowbits(k);
            }
            k = left;
            while (k > 0) {
                sum -= t[k];
                k -= lowbits(k);
            }
            return sum;
        }
    }
}
