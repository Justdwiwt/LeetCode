package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_1345 {
    public int minJumps(int[] arr) {
        Deque<Integer> queue = new ArrayDeque<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[arr.length];
        IntStream.range(0, arr.length).forEach(i -> {
            Set<Integer> neighbors = map.getOrDefault(arr[i], new HashSet<>());
            neighbors.add(i);
            map.put(arr[i], neighbors);
        });
        queue.offer(0);
        visited[0] = true;
        int res = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize-- > 0) {
                int peek = queue.poll();
                if (peek == arr.length - 1) return res;
                if (peek + 1 < arr.length && !visited[peek + 1]) {
                    queue.offer(peek + 1);
                    visited[peek + 1] = true;
                }
                if (peek - 1 >= 0 && !visited[peek - 1]) {
                    queue.offer(peek - 1);
                    visited[peek - 1] = true;
                }
                Set<Integer> neighbors = map.get(arr[peek]);
                if (neighbors != null) neighbors
                        .stream()
                        .filter(neighbor -> !visited[neighbor])
                        .forEach(neighbor -> {
                            queue.offer(neighbor);
                            visited[neighbor] = true;
                        });
                map.remove(arr[peek]);
            }
            res++;
        }
        return -1;
    }
}
