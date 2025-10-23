package main.java;

import java.util.List;

public class Solution_2869 {
    public int minOperations(List<Integer> nums, int k) {
        boolean[] isVisited = new boolean[k + 1];
        for (int index = nums.size() - 1, remainQty = k; ; index--) {
            int value = nums.get(index);
            if (value <= k && !isVisited[value]) {
                isVisited[value] = true;
                if (--remainQty == 0) return nums.size() - index;
            }
        }
    }
}
