package main.java;

import java.util.*;

public class Solution_218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> points = new ArrayList<>();
        Arrays.stream(buildings).forEach(bd -> {
            points.add(new int[]{bd[0], -bd[2]});
            points.add(new int[]{bd[1], bd[2]});
        });

        points.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        List<List<Integer>> res = new ArrayList<>();
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        q.add(0);
        int prev = 0;
        for (int[] point : points) {
            int x = point[0], h = point[1];
            if (h < 0) q.add(-h);
            else if (h > 0) map.put(h, map.getOrDefault(h, 0) + 1);
            int t;
            while ((t = map.getOrDefault(q.peek(), 0)) != 0) {
                map.remove(q.peek());
                while (t-- > 0) q.poll();
            }
            int height = q.peek();
            if (height != prev) {
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(height);
                res.add(list);
                prev = height;
            }
        }
        return res;
    }
}
