package main.java;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution_909 {
    public int snakesAndLadders(int[][] board) {
        int start = 1;
        int n = board.length;
        int end = n * n;
        LinkedList<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(start, 0);
        queue.add(start);
        while (!queue.isEmpty()) {
            int s = queue.removeFirst();
            if (s >= end) return map.get(s);
            for (int i = s + 1; i <= Math.min(end, s + 6); i++) {
                int x = n - 1 - (i - 1) / n;
                int y = (n - 1 - x) % 2 == 0 ? i % n != 0 ? i % n - 1 : n - 1 : i % n != 0 ? n - (i % n) : 0;
                start = board[x][y] != -1 ? board[x][y] : i;
                if (!map.containsKey(start)) {
                    map.put(start, map.get(s) + 1);
                    queue.add(start);
                }
            }
        }
        return -1;
    }
}
