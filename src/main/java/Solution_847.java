package main.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution_847 {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        boolean[][] book = new boolean[n][1 << n];
        int k = (1 << n) - 1;
        Queue<int[]> queue = new LinkedList<>();
        IntStream.range(0, n).mapToObj(i -> new int[]{i, 1 << i}).forEach(queue::offer);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] node = queue.poll();
                assert node != null;
                if (k == node[1]) return step;
                Arrays.stream(graph[node[0]]).forEach(next -> {
                    int next_state = node[1] | (1 << next);
                    if (book[next][next_state]) return;
                    book[next][next_state] = true;
                    queue.offer(new int[]{next, next_state});
                });
            }
            step++;
        }
        return step;
    }
}
