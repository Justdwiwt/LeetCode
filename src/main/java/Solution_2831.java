package main.java;

import java.util.HashMap;
import java.util.List;

public class Solution_2831 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 1, left = 0, mod = 0;
        for (int right = 0; right < nums.size(); right++) {
            int currentNum = nums.get(right);
            map.put(currentNum, map.getOrDefault(currentNum, 0) + 1);
            mod = Math.max(mod, map.get(currentNum));
            while ((right - left + 1) - mod > k) {
                int leftC = nums.get(left);
                map.put(leftC, map.get(leftC) - 1);
                left++;
            }
            ans = Math.max(ans, mod);
        }
        return ans;
    }
}
