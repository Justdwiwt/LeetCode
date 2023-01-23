package main.java;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_1293 {
    static class Node {
        int row, col;
        int k;

        public Node(int row, int col, int k) {
            this.row = row;
            this.col = col;
            this.k = k;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        Queue<Node> q = new LinkedList<>();
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        boolean[][][] visited = new boolean[k + 1][grid.length][grid[0].length];
        q.offer(new Node(0, 0, k));
        visited[k][0][0] = true;
        int step = 0;
        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node t = q.poll();
                if (t.row == grid.length - 1 && t.col == grid[0].length - 1) return step - 1;
                for (int[] direction : directions) {
                    int row = t.row + direction[0], col = t.col + direction[1];
                    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) if (grid[row][col] == 1) {
                        if (t.k > 0 && !visited[t.k - 1][row][col]) {
                            q.offer(new Node(row, col, t.k - 1));
                            visited[t.k - 1][row][col] = true;
                        }
                    } else if (!visited[t.k][row][col]) {
                        q.offer(new Node(row, col, t.k));
                        visited[t.k][row][col] = true;
                    }
                }
            }
        }
        return -1;
    }
}
