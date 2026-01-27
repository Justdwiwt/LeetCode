package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution_3006 {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        TreeSet<Integer> set1 = find(s, a), set2 = find(s, b);
        List<Integer> ans = new ArrayList<>();
        for (int idx : set1) {
            Integer p = set2.ceiling(idx);
            if (p != null && p - idx <= k) {
                ans.add(idx);
                continue;
            }
            p = set2.floor(idx);
            if (p != null && idx - p <= k) ans.add(idx);
        }
        return ans;
    }

    TreeSet<Integer> find(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] next = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && t.charAt(j) != t.charAt(j)) j = next[j - 1];
            if (t.charAt(j) == t.charAt(i)) j++;
            next[i] = j;
        }
        TreeSet<Integer> ans = new TreeSet<>();
        for (int i = 0, j = 0; i < m; i++) {
            while (j > 0 && t.charAt(j) != s.charAt(i)) j = next[j - 1];
            if (t.charAt(j) == s.charAt(i)) j++;
            if (j == n) {
                ans.add(i - n + 1);
                j = next[j - 1];
            }
        }
        return ans;
    }
}
