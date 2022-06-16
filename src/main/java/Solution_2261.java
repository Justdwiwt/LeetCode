package main.java;

import java.util.HashSet;

public class Solution_2261 {
    public int countDistinct(int[] nums, int k, int p) {
        HashSet<String> st = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < nums.length; j++) {
                sb.append(nums[j]).append("+");
                if (nums[j] % p == 0) cnt++;
                if (cnt > k) break;
                st.add(sb.toString());
            }
        }
        return st.size();
    }
}
