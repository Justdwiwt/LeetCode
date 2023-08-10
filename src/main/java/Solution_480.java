package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_480 {
    private List<Integer> window;

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] res = new double[n - k + 1];
        window = new ArrayList<>();
        int left = 0;
        for (int num : nums) {
            insert(num);
            if (window.size() == k) {
                res[left] = k % 2 == 0 ? (double) window.get(k / 2 - 1) / 2 + (double) window.get(k / 2) / 2 : window.get(k / 2);
                remove(nums[left]);
                left++;
            }
        }
        return res;
    }

    private void insert(int val) {
        int left = 0;
        int right = window.size();
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (window.get(mid) < val) left = mid + 1;
            else right = mid;
        }
        window.add(left, val);
    }

    private void remove(int val) {
        int left = 0;
        int right = window.size() - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (window.get(mid) < val) left = mid + 1;
            else if (window.get(mid) > val) right = mid - 1;
            else {
                window.remove(mid);
                return;
            }
        }
    }
}
