package main.java;

import java.util.List;

public class Solution_2855 {
    public int minimumRightShifts(List<Integer> nums) {
        int min = Integer.MAX_VALUE, minIdx = 0, size = nums.size();
        if (size == 1) return 0;

        for (int i = 0; i < size; i++)
            if (nums.get(i) < min) {
                minIdx = i;
                min = nums.get(i);
            }

        for (int i = minIdx + 1; i < minIdx + size; i++)
            if (nums.get(i % size) <= nums.get((i - 1) % size))
                return -1;
        return (size - minIdx) % size;
    }
}
