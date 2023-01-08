package main.java;

import java.util.LinkedList;

public class Solution_1349 {
    public int maxStudents(char[][] seats) {
        long[][] mutual = new long[seats.length][seats[0].length];
        int w = seats[0].length;
        int res = 0;
        LinkedList<int[]> locals = new LinkedList<>();
        for (int i = 0; i < seats.length; i++)
            for (int j = 0; j < seats[i].length; j++)
                if (seats[i][j] == '.') {
                    mutual[i][j] = ~0;
                    if (i - 1 >= 0 && j - 1 >= 0) mutual[i][j] &= ~(1L << ((i - 1) * w + j - 1));
                    if (j - 1 >= 0) mutual[i][j] &= ~(1L << (i * w + j - 1));
                    if (i - 1 >= 0 && j + 1 < w) mutual[i][j] &= ~(1L << ((i - 1) * w + j + 1));
                    if (j + 1 < w) mutual[i][j] &= ~(1L << ((i) * w + j + 1));
                    locals.addLast(new int[]{i, j});
                }
        LinkedList<Long> queue = new LinkedList<>();
        queue.addLast(0L);
        while (!locals.isEmpty()) {
            int[] local = locals.poll();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Long thisNode = queue.pollFirst();
                Long nextNode = thisNode;
                nextNode |= 1L << (local[0] * w + local[1]);
                nextNode &= mutual[local[0]][local[1]];
                res = Math.max(res, Long.bitCount(nextNode));
                if (Long.bitCount(nextNode) + 2 > res) queue.addLast(nextNode);
                if (Long.bitCount(thisNode) + 2 > res) queue.addLast(thisNode);
            }
        }
        return res;
    }
}
