package main.java;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Solution_1847 {
    public int[] closestRoom(int[][] rooms, int[][] qs) {
        int n = rooms.length, m = qs.length;
        int[] res = new int[m];
        Integer[] pos = IntStream.range(0, m).boxed().toArray(Integer[]::new);
        Arrays.sort(pos, (o1, o2) -> qs[o2][1] - qs[o1][1]);
        Arrays.sort(rooms, (o1, o2) -> o2[1] - o1[1]);
        int k = 0;
        TreeSet<Integer> ts = new TreeSet<>();
        for (int x : pos) {
            int id = qs[x][0], area = qs[x][1];
            while (k < n && rooms[k][1] >= area)
                ts.add(rooms[k++][0]);
            if (ts.size() == 0) res[x] = -1;
            else {
                Integer floor = ts.floor(id);
                Integer ceil = ts.ceiling(id);
                if (floor == null || ceil == null) res[x] = floor == null ? ceil : floor;
                else {
                    int a = Math.abs(floor - id), b = Math.abs(ceil - id);
                    res[x] = a <= b ? floor : ceil;
                }
            }
        }
        return res;
    }
}
