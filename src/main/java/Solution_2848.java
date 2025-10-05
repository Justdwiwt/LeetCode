package main.java;

import java.util.Comparator;
import java.util.List;

public class Solution_2848 {
    public int numberOfPoints(List<List<Integer>> nums) {
        nums.sort(Comparator.comparingInt(o -> o.get(0)));
        int l = nums.get(0).get(0), r = nums.get(0).get(1), m = 0;
        for (int i = 1; i < nums.size(); i++)
            if (nums.get(i).get(0) <= r) r = Math.max(r, nums.get(i).get(1));
            else {
                m += (r - l + 1);
                l = nums.get(i).get(0);
                r = nums.get(i).get(1);
            }
        return m + (r - l + 1);
    }
}
