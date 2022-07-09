package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_2155 {
    public List<Integer> maxScoreIndices(int[] nums) {
        int preSum = 0, mx = 0;
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == 0) {
                preSum += 1;
                if (preSum > mx) {
                    mx = preSum;
                    res.clear();
                    res.add(i + 1);
                } else if (preSum == mx)
                    res.add(i + 1);
            } else preSum -= 1;
        return res;
    }
}
