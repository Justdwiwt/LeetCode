package main.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution_1620 {
    private static final int[][] diff = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int[] bestCoordinate(int[][] towers, int radius) {
        boolean[][] visit = new boolean[101][101];
        Queue<int[]> q = new LinkedList<>();
        int[][] cn = new int[101][101];
        int[] tmp;
        int nx, ny, k, dis;
        for (int[] t : towers) {
            q.offer(new int[]{t[0], t[1], t[2]});
            visit[t[0]][t[1]] = true;
            while (!q.isEmpty()) {
                tmp = q.poll();
                cn[tmp[0]][tmp[1]] += tmp[2];
                for (int[] d : diff) {
                    nx = tmp[0] + d[0];
                    ny = tmp[1] + d[1];
                    dis = (nx - t[0]) * (nx - t[0]) + (ny - t[1]) * (ny - t[1]);
                    if (nx < 0 || ny < 0 || dis > radius * radius || visit[nx][ny])
                        continue;
                    visit[nx][ny] = true;
                    k = (int) (t[2] / (1 + Math.sqrt(dis)));
                    q.offer(new int[]{nx, ny, k});
                }
            }
            IntStream.range(0, visit.length).forEach(i -> Arrays.fill(visit[i], false));
        }
        int max = 0;
        int[] res = new int[2];
        for (int i = 0; i < cn.length; i++)
            for (int j = 0; j < cn[0].length; j++)
                if (cn[i][j] > max) {
                    res[0] = i;
                    res[1] = j;
                    max = cn[i][j];
                }
        return res;
    }
}
