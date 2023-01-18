package main.java;

import java.util.ArrayList;

public class Solution_1313 {
    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2)
            while (nums[i] > 0) {
                list.add(nums[i + 1]);
                nums[i]--;
            }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
