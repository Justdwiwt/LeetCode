package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_2899 {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> seen = new ArrayList<>();
        int k = 0;
        for (int x : nums)
            if (x > 0) {
                seen.add(x);
                k = 0;
            } else ans.add(++k > seen.size() ? -1 : seen.get(seen.size() - k));
        return ans;
    }
}
