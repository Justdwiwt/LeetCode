package main.java;

public class Solution_922 {
    public int[] sortArrayByParityII(int[] nums) {
        int[] res = new int[nums.length];
        int index1 = 1;
        int index2 = 0;
        for (int num : nums)
            if (num % 2 == 0) res[2 * index2++] = num;
            else res[2 * index1++ - 1] = num;
        return res;
    }
}
