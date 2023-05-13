package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_841 {
    private void dfs(int key, List<List<Integer>> rooms, List<Boolean> visited) {
        if (visited.get(key)) return;
        visited.set(key, true);
        rooms.get(key).forEach(k -> dfs(k, rooms, visited));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Boolean> visited = new ArrayList<Boolean>() {{
            IntStream.range(0, rooms.size()).mapToObj(i -> false).forEach(this::add);
        }};
        dfs(0, rooms, visited);
        for (boolean flag : visited) if (!flag) return false;
        return true;
    }
}
