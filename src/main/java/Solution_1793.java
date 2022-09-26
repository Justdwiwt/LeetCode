package main.java;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class Solution_1793 {
    public int maximumScore(int[] nums, int k) {
        int[] left = new int[nums.length], right = new int[nums.length];
        Arrays.fill(left, -1);
        Arrays.fill(right, nums.length);
        Stack<Integer> st = new Stack<>();
        IntStream.range(0, nums.length).forEach(i -> {
            while (st.size() > 0 && nums[st.peek()] > nums[i])
                right[st.pop()] = i;
            st.push(i);
        });
        st.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (st.size() > 0 && nums[st.peek()] > nums[i])
                left[st.pop()] = i;
            st.push(i);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++)
            if (left[i] < k && right[i] > k)
                res = Math.max(res, nums[i] * (right[i] - left[i] - 1));
        return res;
    }
}
