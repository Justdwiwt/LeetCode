package main.java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution_2059 {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int step = 1;

        q.offer(start);
        set.add(start);

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int val = q.poll();
                for (int n : nums)
                    for (int op : new int[]{val ^ n, val - n, val + n}) {
                        if (op == goal) return step;
                        if (op >= 0 && op <= 1000 && set.add(op)) q.offer(op);
                    }
            }
            step++;
        }
        return -1;
    }
}
