package main.java;

import java.util.*;

public class Solution_1923 {
    private final long[] diff = {100000007, 100000037};

    public int longestCommonSubpath(int n, int[][] paths) {
        long[] inverse = calculateInverse(n);
        Arrays.sort(paths, Comparator.comparingInt(a -> a.length));
        int min = 0;
        int max = paths[0].length;
        while (min < max) {
            int mid = (min + max + 1) >> 1;
            if (judge(paths, mid, n, inverse)) min = mid;
            else max = mid - 1;
        }
        return min;
    }

    private long[] calculateInverse(long base) {
        return Arrays
                .stream(diff)
                .map(eachP -> {
                    long tmp = base;
                    long inverse = 1;
                    for (char c : new StringBuilder(Long.toBinaryString(eachP - 2)).reverse().toString().toCharArray()) {
                        if (c == '1') {
                            inverse *= tmp;
                            inverse %= eachP;
                        }
                        tmp *= tmp;
                        tmp %= eachP;
                    }
                    return inverse;
                })
                .toArray();
    }

    private boolean judge(int[][] paths, int commonPathLength, long base, long[] baseInverse) {
        Map<Long, Set<Long>> samePathHash = new HashMap<>();
        boolean flag = true;
        for (int[] path : paths) {
            long[] curHash = new long[2];
            long[] curBase = new long[]{1, 1};
            for (int i = 0; i < commonPathLength - 1; i++)
                for (int j = 0; j <= 1; j++) {
                    curHash[j] += (curBase[j] * (path[i]));
                    curHash[j] %= diff[j];
                    curBase[j] *= base;
                    curBase[j] %= diff[j];
                }

            Map<Long, Set<Long>> tmp = new HashMap<>();
            for (int i = commonPathLength - 1; i < path.length; i++) {
                for (int j = 0; j <= 1; j++) {
                    curHash[j] += (curBase[j] * (path[i]));
                    curHash[j] %= diff[j];
                }

                if (flag) samePathHash.computeIfAbsent(curHash[0], key -> new HashSet<>()).add(curHash[1]);
                else if (samePathHash.getOrDefault(curHash[0], Collections.emptySet()).contains(curHash[1]))
                    tmp.computeIfAbsent(curHash[0], key -> new HashSet<>()).add(curHash[1]);
                for (int j = 0; j <= 1; j++) {
                    curHash[j] -= path[i - commonPathLength + 1];
                    curHash[j] *= baseInverse[j];
                    curHash[j] %= diff[j];
                }
            }
            if (flag) flag = false;
            else {
                if (tmp.isEmpty()) return false;
                samePathHash = tmp;
            }
        }
        return true;
    }
}
