package main.java;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class Solution_1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        IntStream.range(0, nums.length).forEach(i -> {
            while (!st.isEmpty() && (k - st.size() <= nums.length - i - 1) && nums[st.peek()] > nums[i])
                st.pop();
            st.push(i);
        });
        return Arrays.copyOf(st.stream().mapToInt(num -> nums[num]).toArray(), k);
    }
}
