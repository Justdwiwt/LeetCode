package main.java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_84 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> dq = new ArrayDeque<>();
        int res = 0;
        dq.addLast(0);
        List<Integer> list = Arrays.stream(heights).boxed().collect(Collectors.toList());
        list.add(-1);
        for (int index = 1; index < list.size(); index++) {
            if (list.get(index) < list.get(dq.getLast())) {
                while (!dq.isEmpty() && list.get(index) < list.get(dq.getLast())) {
                    int mid = dq.removeLast();
                    int temp = list.get(mid) * (index - mid);
                    if (dq.isEmpty()) temp += list.get(mid) * mid;
                    else temp += list.get(mid) * (mid - dq.getLast() - 1);
                    res = Math.max(temp, res);
                }
            }
            dq.addLast(index);
        }
        return res;
    }
}
