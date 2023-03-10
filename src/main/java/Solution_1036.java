package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution_1036 {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> st = Arrays.stream(blocked).map(ints -> ints[0] + "" + ints[1]).collect(Collectors.toSet());
        return dfs(source[0], source[1], st, new HashSet<>(), source, target) && dfs(target[0], target[1], st, new HashSet<>(), target, source);
    }

    private boolean dfs(int x, int y, Set<String> ans, Set<String> visited, int[] source, int[] target) {
        if ((x == target[0] && y == target[1])) return true;
        String temp = x + "" + y;
        if (visited.contains(temp) || ans.contains(temp) || x < 0 || y < 0 || x > 999999 || y > 999999) return false;
        if (Math.abs(x - source[0]) + Math.abs(y - source[1]) > 200) return true;
        visited.add(temp);
        if (dfs(x, y + 1, ans, visited, source, target) || dfs(x + 1, y, ans, visited, source, target) || dfs(x - 1, y, ans, visited, source, target))
            return true;
        return dfs(x, y - 1, ans, visited, source, target);
    }
}
