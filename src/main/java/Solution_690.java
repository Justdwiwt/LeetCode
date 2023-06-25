package main.java;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution_690 {
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    private int sum = 0;

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = employees.stream().collect(Collectors.toMap(e -> e.id, e -> e, (a, b) -> b));
        return dfs(id, map);
    }

    public int dfs(int id, Map<Integer, Employee> map) {
        sum += map.get(id).importance;
        map.get(id).subordinates.forEach(a -> dfs(a, map));
        return sum;
    }
}
