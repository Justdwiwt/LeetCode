package main.java;

public class Solution_2717 {
    public int semiOrderedPermutation(int[] nums) {
        int index1 = 0, indexN = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) index1 = i;
            if (nums[i] == n) indexN = i;
        }
        int res = index1 + (n - indexN - 1);
        if (indexN < index1) res--;
        return res;
    }
}
