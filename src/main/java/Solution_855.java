package main.java;

import java.util.TreeSet;

public class Solution_855 {
    static class ExamRoom {
        TreeSet<Integer> set;
        int n;

        public ExamRoom(int n) {
            set = new TreeSet<>();
            this.n = n;
        }

        public int seat() {
            if (set.isEmpty()) {
                set.add(0);
                return 0;
            }
            int max = 0, pre = -1, l = -1, r = 0;
            for (Integer idx : set) {
                if (pre == -1) {
                    r = idx;
                    max = r - l;
                } else if ((idx - pre) / 2 > max / 2) {
                    r = idx;
                    l = pre;
                    max = r - l;
                }
                pre = idx;
            }
            if (n - set.last() > max) {
                set.add(n - 1);
                return n - 1;
            }
            if (l == -1) {
                set.add(0);
                return 0;
            }
            set.add((l + r) / 2);
            return (l + r) / 2;
        }

        public void leave(int p) {
            set.remove(p);
        }
    }
}
