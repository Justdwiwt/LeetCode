package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_2607 {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;
        long ans = 0;
        k = gcd(n, k);
        for (int i = 0; i < k; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < n; j += k) list.add(arr[j]);
            Collections.sort(list);
            int mid = list.get(list.size() / 2);
            ans += list.stream().mapToInt(num -> num).mapToLong(num -> Math.abs(num - mid)).sum();
        }
        return ans;
    }
}
