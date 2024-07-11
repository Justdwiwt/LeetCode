package main.java;

import java.util.*;

public class Solution_1778 {
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    Set<Integer> arrival = new HashSet<>();
    Set<Integer> f = new HashSet<>();
    int[] tar = new int[2];

    public int findShortestPath(Solution_1810.GridMaster master) {
        tar[0] = Integer.MAX_VALUE;
        tar[1] = Integer.MAX_VALUE;
        dfs(0, 0, master);
        Queue<int[]> q = new LinkedList<>();

        arrival.clear();
        q.offer(new int[]{0, 0});
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] polled = q.poll();
                int x = polled[0], y = polled[1];
                if (x == tar[0] && y == tar[1]) return count;
                Arrays.stream(dir).forEach(dxx -> {
                    int nx = x + dxx[0];
                    int ny = y + dxx[1];
                    if (f.contains(hash(nx, ny)) || arrival.contains(hash(nx, ny))) return;
                    else {
                        arrival.add(hash(nx, ny));
                        q.offer(new int[]{nx, ny});
                    }
                });

            }
            count++;
        }
        return -1;
    }

    public void dfs(int x, int y, Solution_1810.GridMaster master) {
        if (!arrival.add(hash(x, y))) return;
        if (master.isTarget()) tar = new int[]{x, y};
        if (master.canMove('U')) {
            master.move('U');
            dfs(x + 1, y, master);
            master.move('D');
        } else f.add(hash(x + 1, y));
        if (master.canMove('D')) {
            master.move('D');
            dfs(x - 1, y, master);
            master.move('U');
        } else f.add(hash(x - 1, y));
        if (master.canMove('L')) {
            master.move('L');
            dfs(x, y - 1, master);
            master.move('R');
        } else f.add(hash(x, y - 1));
        if (master.canMove('R')) {
            master.move('R');
            dfs(x, y + 1, master);
            master.move('L');
        } else f.add(hash(x, y + 1));
    }

    public int hash(int x, int y) {
        return x * 3600000 + y;
    }
}
