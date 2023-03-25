package main.java;

import java.util.stream.IntStream;

public class Solution_990 {
    public boolean equationsPossible(String[] equations) {
        int[] arr = IntStream.range(0, 26).toArray();

        IntStream.range(0, equations.length)
                .filter(i -> equations[i].charAt(1) == '=')
                .forEach(i -> union(arr, equations[i].charAt(0), equations[i].charAt(3)));

        return IntStream.range(0, equations.length)
                .filter(i -> equations[i].charAt(1) == '!')
                .noneMatch(i -> find(arr, equations[i].charAt(0) - 'a') == find(arr, equations[i].charAt(3) - 'a'));
    }

    private void union(int[] a, char x, char y) {
        int a1 = x - 'a';
        int b1 = y - 'a';
        a[find(a, b1)] = find(a, a1);
    }

    private int find(int[] a, int x) {
        return a[x] == x ? x : find(a, a[x]);
    }
}
