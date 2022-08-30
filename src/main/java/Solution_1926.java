package main.java;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] diff = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<Integer> q = new LinkedList<>();
        q.offer(entrance[0]);
        q.offer(entrance[1]);
        for (int cur = 0; !q.isEmpty(); cur++) {
            int n = q.size() / 2;
            for (int k = 0; k < n; k++) {
                int i = q.poll(), j = q.poll();
                for (int[] dir : diff)
                    if (i + dir[0] >= 0 && i + dir[0] < maze.length && j + dir[1] >= 0 && j + dir[1] < maze[0].length) {
                        if (maze[i + dir[0]][j + dir[1]] == '.') {
                            maze[i + dir[0]][j + dir[1]] = '+';
                            q.offer(i + dir[0]);
                            q.offer(j + dir[1]);
                        }
                    } else if (i != entrance[0] || j != entrance[1]) return cur;
            }
        }
        return -1;
    }
}
