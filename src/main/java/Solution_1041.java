package main.java;

public class Solution_1041 {
    private final int[][] diff = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, dir = 0;
        for (char c : instructions.toCharArray())
            if (c == 'G') {
                x += diff[dir][0];
                y += diff[dir][1];
            } else dir = c == 'L' ? (dir + 3) % 4 : (dir + 1) % 4;
        return dir != 0 || x == 0 && y == 0;
    }
}
