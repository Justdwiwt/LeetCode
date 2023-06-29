package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_675 {
    List<List<Integer>> map;
    final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int cutOffTree(List<List<Integer>> forest) {
        map = forest;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < map.size(); i++)
            for (int j = 0; j < map.get(i).size(); j++)
                if (map.get(i).get(j) > 1) list.add(new int[]{i, j});
        list.sort(Comparator.comparingInt(x -> forest.get(x[0]).get(x[1])));
        list.add(0, new int[]{0, 0});
        int res = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            int distance = bfs(list.get(i), list.get(i + 1));
            if (distance == -1 || map.get(list.get(i)[0]).get(list.get(i)[1]) == 0) return -1;
            res += distance;
        }
        return res;
    }

    public int bfs(int[] begin, int[] end) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        int[][] tmp = new int[map.size()][map.get(0).size()];
        IntStream.range(0, map.size()).forEach(i -> Arrays.fill(tmp[i], Integer.MAX_VALUE));
        queue.add(new int[]{0, 0, begin[0], begin[1]});
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            if (xy[2] == end[0] && xy[3] == end[1]) return xy[1];
            Arrays.stream(dir).forEach(d -> {
                int x = xy[2] + d[0], y = xy[3] + d[1];
                int num = Math.abs(x - end[0]) + Math.abs(y - end[1]) + xy[1] + 1;
                if (x >= 0 && x < map.size() && y >= 0 && y < map.get(0).size() && num < tmp[x][y] && map.get(x).get(y) != 0) {
                    queue.add(new int[]{num, xy[1] + 1, x, y});
                    tmp[x][y] = num;
                }
            });
        }
        return -1;
    }
}
