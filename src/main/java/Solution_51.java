package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_51 {
    List<List<String>> list1 = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] bored = new char[n][n];
        Arrays.stream(bored).forEach(b -> Arrays.fill(b, '.'));
        backTracking(bored, 0, n);
        return list1;
    }

    public void backTracking(char[][] bored, int row, int n) {
        if (row == n) list1.add(newArrayList(bored));
        IntStream.range(0, n).forEach(i -> {
            if (isValid(bored, n, row, i)) {
                bored[row][i] = 'Q';
                backTracking(bored, row + 1, n);
                bored[row][i] = '.';
            } else return;
        });
    }

    public boolean isValid(char[][] bored, int n, int row, int col) {
        return IntStream
                .range(0, n)
                .noneMatch(h -> bored[h][col] == 'Q') && (IntStream.range(0, n)
                .noneMatch(i -> i + col - row >= 0 && i + col - row < n && bored[i][i + col - row] == 'Q') && IntStream.range(0, n)
                .noneMatch(i -> col + row - i >= 0 && col + row - i < n && bored[i][col + row - i] == 'Q'));
    }

    public List<String> newArrayList(char[][] bored) {
        return Arrays
                .stream(bored)
                .map(String::copyValueOf)
                .collect(Collectors.toList());
    }
}
