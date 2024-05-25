package main.java;

public class Solution_75 {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for (int num : nums)
            if (num == 0) red++;
            else if (num == 1) white++;
            else if (num == 2) blue++;

        int i = 0;
        for (int j = 0; j < red; j++) nums[i++] = 0;
        for (int j = 0; j < white; j++) nums[i++] = 1;
        for (int j = 0; j < blue; j++) nums[i++] = 2;
    }
}
