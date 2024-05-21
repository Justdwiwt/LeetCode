package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_77 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        IntStream.rangeClosed(startIndex, n).forEach(i -> {
            path.add(i);
            backtracking(n, k, i + 1);
            path.remove(path.size() - 1);
        });
    }
}
