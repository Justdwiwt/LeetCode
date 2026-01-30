package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_3008 {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> la = kmp(s, a), lb = kmp(s, b);
        if (la.isEmpty() || lb.isEmpty()) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int size = Math.max(la.get(la.size() - 1), lb.get(lb.size() - 1)) + 1 + k;
        Tree t = new Tree(size);
        lb.forEach(x -> t.add(x + 1, 1));
        la.forEach(x -> {
            int l = t.search(x - k), r = t.search(x + k + 1);
            if (r - l > 0) res.add(x);
        });
        return res;
    }

    public List<Integer> kmp(String s, String a) {
        int n = s.length(), m = a.length();
        s = " " + s;
        a = " " + a;
        char[] c = s.toCharArray();
        char[] p = a.toCharArray();
        int[] next = new int[m + 1];
        for (int i = 2, j = 0; i <= m; i++) {
            while (j != 0 && p[j + 1] != p[i]) j = next[j];
            if (p[j + 1] == p[i]) j++;
            next[i] = j;
        }
        List<Integer> lists = new ArrayList<>();
        for (int i = 1, j = 0; i <= n; i++) {
            while (j != 0 && c[i] != p[j + 1]) j = next[j];
            if (c[i] == p[j + 1]) j++;
            if (j == m) {
                lists.add(i - m);
                j = next[j];
            }
        }
        return lists;
    }

    static class Tree {
        int[] nums;
        int size;

        Tree(int n) {
            nums = new int[n + 1];
            size = n;
        }

        public void add(int x, int val) {
            while (x <= size) {
                nums[x] += val;
                x += func(x);
            }
        }

        public int search(int x) {
            int res = 0;
            while (x > 0) {
                res += nums[x];
                x -= func(x);
            }
            return res;
        }

        public int func(int x) {
            return x & (-x);
        }
    }
}
