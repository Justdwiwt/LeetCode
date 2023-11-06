package main.java;

import java.util.*;

public class Solution_332 {
    private final Map<String, PriorityQueue<String>> map = new HashMap<>();

    private final List<String> resList = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.forEach(ticket -> {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            if (!map.containsKey(src)) {
                PriorityQueue<String> pq = new PriorityQueue<>();
                map.put(src, pq);
            }
            map.get(src).add(dst);
        });
        dfs("JFK");
        return resList;
    }

    private void dfs(String src) {
        PriorityQueue<String> pq = map.get(src);
        while (pq != null && !pq.isEmpty()) dfs(pq.poll());
        ((LinkedList<String>) resList).addFirst(src);
    }
}
