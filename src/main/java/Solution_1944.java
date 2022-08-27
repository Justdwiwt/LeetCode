package main.java;

import java.util.Stack;
import java.util.stream.IntStream;

public class Solution_1944 {
    public int[] canSeePersonsCount(int[] heights) {
        int[] res = new int[heights.length];
        Stack<int[]> st = new Stack<>();
        IntStream.range(0, heights.length).forEach(i -> {
            int h = heights[i];
            while (!st.isEmpty() && st.peek()[0] < h) {
                int prev = st.pop()[1];
                res[prev]++;
            }
            if (!st.isEmpty()) res[st.peek()[1]]++;
            st.push(new int[]{h, i});
        });
        return res;
    }
}
