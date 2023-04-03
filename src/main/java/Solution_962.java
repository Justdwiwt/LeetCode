package main.java;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Solution_962 {
    public int maxWidthRamp(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        IntStream.range(1, nums.length).filter(i -> nums[i] < nums[stack.peek()]).forEach(stack::push);
        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--)
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) max = Math.max(max, i - stack.pop());
        return max;
    }
}
