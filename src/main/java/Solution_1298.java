package main.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1298 {
    static final int HAS_OPEN = 1;
    static final int HAS_BOX = 1 << 1;
    static final int HAS_DEAL = 1 << 2;

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> queue = new LinkedList<>();

        Arrays.stream(initialBoxes).forEach(i -> {
            status[i] = addStatus(status[i], HAS_BOX);
            if (status[i] == (HAS_BOX | HAS_OPEN)) {
                queue.offer(i);
                status[i] = addStatus(status[i], HAS_DEAL);
            }
        });

        int res = 0;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            res += candies[i];
            Arrays.stream(keys[i]).forEach(j -> {
                status[j] = addStatus(status[j], HAS_OPEN);
                if (status[j] == (HAS_BOX | HAS_OPEN)) {
                    queue.offer(j);
                    status[j] = addStatus(status[j], HAS_DEAL);
                }
            });

            Arrays.stream(containedBoxes[i]).forEach(j -> {
                status[j] = addStatus(status[j], HAS_BOX);
                if (status[j] == (HAS_BOX | HAS_OPEN)) {
                    queue.offer(j);
                    status[j] = addStatus(status[j], HAS_DEAL);
                }
            });
        }
        return res;
    }

    private int addStatus(int nowStatus, int status) {
        return nowStatus | status;
    }
}
