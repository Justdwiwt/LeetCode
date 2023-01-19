package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_1311 {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(id);
        boolean[] vis = new boolean[watchedVideos.size()];
        vis[id] = true;
        while (!deque.isEmpty() && level > 0) {
            int size = deque.size();
            while (size-- > 0) {
                int cur = deque.poll();
                Arrays.stream(friends[cur]).filter(f -> !vis[f]).forEach(f -> {
                    deque.offer(f);
                    vis[f] = true;
                });
            }
            level--;
        }
        Map<String, Integer> cnt = new HashMap<>();
        while (!deque.isEmpty()) {
            int f = deque.poll();
            watchedVideos.get(f).forEach(w -> cnt.put(w, cnt.getOrDefault(w, 0) + 1));
        }
        return cnt.entrySet().stream()
                .sorted((o1, o2) -> Objects.equals(o1.getValue(), o2.getValue()) ? o1.getKey().compareTo(o2.getKey()) : o1.getValue() - o2.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
