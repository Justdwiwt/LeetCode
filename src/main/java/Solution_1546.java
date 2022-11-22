package main.java;

import java.util.HashSet;
import java.util.Set;

public class Solution_1546 {
    public int maxNonOverlapping(int[] nums, int target) {
        int sum = 0;
        int res = 0;
        Set<Integer> st = new HashSet<>();
        st.add(0);
        for (int num : nums) {
            sum += num;
            int t = sum - target;
            if (st.contains(t)) {
                res++;
                st.clear();
                sum = 0;
            }
            st.add(sum);
        }
        return res;
    }
}
