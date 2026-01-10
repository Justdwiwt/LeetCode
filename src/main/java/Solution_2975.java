package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_2975 {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> h = f(hFences, m);
        Set<Integer> v = f(vFences, n);
        int ans = 0;
        for (int x : h)
            if (v.contains(x)) ans = Math.max(ans, x);
        return ans > 0 ? (int) ((long) ans * ans % 1_000_000_007) : -1;
    }

    private Set<Integer> f(int[] a, int mx) {
        int len = a.length;
        a = Arrays.copyOf(a, len + 2);
        a[len] = 1;
        a[len + 1] = mx;
        Arrays.sort(a);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                set.add(a[j] - a[i]);
        return set;
    }
}
