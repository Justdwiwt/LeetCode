package main.java;

import java.util.HashMap;
import java.util.List;

public class Solution_554 {
    public int leastBricks(List<List<Integer>> walls) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (List<Integer> wall : walls) {
            int sum = wall.get(0);
            for (int i = 1; i < wall.size(); i++) {
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                sum += wall.get(i);
            }
        }
        return walls.size() - map.values().stream().max(Integer::compareTo).orElse(0);
    }
}
