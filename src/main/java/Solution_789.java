package main.java;

import java.util.Arrays;

public class Solution_789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int path = Math.abs(target[0]) + Math.abs(target[1]);
        return Arrays.stream(ghosts)
                .mapToInt(ghost -> Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]))
                .noneMatch(ghost_path -> ghost_path <= path);
    }
}
