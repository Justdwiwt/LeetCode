package main.java;

public class Solution_1995 {
    public int countQuadruplets(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 3; i++)
            for (int j = i + 1; j < nums.length - 2; j++)
                for (int k = j + 1; k < nums.length - 1; k++)
                    for (int f = k + 1; f < nums.length; f++)
                        if (nums[i] + nums[j] + nums[k] == nums[f])
                            res++;
        return res;
    }
}
