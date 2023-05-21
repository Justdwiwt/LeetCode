package main.java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution_818 {
    public int racecar(int target) {
        if (target == 0) return 0;
        Set<String> memory = new HashSet<>();
        memory.add("0@1");
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 1, 0});
        int[] curr;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            int[] plan1 = new int[]{curr[0] + curr[1], curr[1] * 2, curr[2] + 1};
            if (plan1[0] == target) return plan1[2];
            if (memory.add(plan1[0] + "@" + plan1[1]) && plan1[0] > 0) queue.add(plan1);
            int[] plan2 = new int[]{curr[0], curr[1], curr[2] + 1};
            plan2[1] = plan2[1] > 0 ? -1 : 1;
            if (memory.add(plan2[0] + "@" + plan2[1]) && plan2[0] > 0) queue.add(plan2);
        }
        return -1;
    }
}
