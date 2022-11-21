package main.java;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution_1552 {
    public int maxDistance(int[] position, int m) {
        TreeSet<Integer> ts = Arrays.stream(position).boxed().collect(Collectors.toCollection(TreeSet::new));
        int l = 1, r = ts.last() - ts.first();
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (canPlace(mid, m - 1, ts)) l = mid;
            else r = mid - 1;
            if (l == r - 1) {
                if (canPlace(r, m - 1, ts)) l = r;
                break;
            }
        }
        return l;
    }

    private boolean canPlace(int d, int m, TreeSet<Integer> set) {
        int a = set.first();
        while (true) {
            if (m <= 0) return true;
            Integer b = set.ceiling(a + d);
            if (b == null) break;
            a = b;
            m--;
        }
        return false;
    }
}
