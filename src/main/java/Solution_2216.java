package main.java;

public class Solution_2216 {
    public int minDeletion(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++)
            if ((i - res) % 2 == 0 && i < nums.length - 1 && nums[i] == nums[i + 1]) res++;
        if ((nums.length - res) % 2 == 1) res++;
        return res;
    }
}
