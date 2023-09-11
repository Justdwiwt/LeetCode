package main.java;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_407 {
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length, m = heightMap[0].length;
        boolean[][] isUsed = new boolean[n][m];
        PriorityQueue<Point> points = new PriorityQueue<>(Comparator.comparingInt(o -> heightMap[o.y][o.x]));
        IntStream.range(0, m).forEach(i -> {
            points.add(new Point(0, i));
            points.add(new Point(n - 1, i));
            isUsed[0][i] = true;
            isUsed[n - 1][i] = true;
        });
        IntStream.range(1, n - 1).forEach(i -> {
            points.add(new Point(i, 0));
            points.add(new Point(i, m - 1));
            isUsed[i][0] = true;
            isUsed[i][m - 1] = true;
        });
        int[] extraX = new int[]{-1, 1, 0, 0};
        int[] extraY = new int[]{0, 0, -1, 1};
        int res = 0, maxH = 0;
        while (!points.isEmpty()) {
            Point point = points.poll();
            int height = heightMap[point.y][point.x];
            maxH = Math.max(maxH, height);
            res += (maxH - height);
            IntStream.range(0, 4).forEach(i -> {
                int newY = point.y + extraY[i], newX = point.x + extraX[i];
                if (newY < 0 || newY >= n || newX < 0 || newX >= m || isUsed[newY][newX]) return;
                points.add(new Point(newY, newX));
                isUsed[newY][newX] = true;
            });
        }
        return res;
    }

    static class Point {
        int y;
        int x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
