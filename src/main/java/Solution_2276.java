package main.java;

import java.util.Map;
import java.util.TreeMap;

public class Solution_2276 {
    static class CountIntervals {
        TreeMap<Integer, Integer> tm;
        int cnt;

        public CountIntervals() {
            tm = new TreeMap<>();
            cnt = 0;
        }

        public void add(int left, int right) {
            Map.Entry<Integer, Integer> pre = tm.floorEntry(left - 1);

            if (pre != null) {
                int preLeft = pre.getKey(), preRight = pre.getValue();
                if (preRight >= left) {
                    int preCount = preRight - preLeft + 1;
                    cnt -= preCount;
                    tm.remove(preLeft);
                    left = preLeft;
                    right = Math.max(right, preRight);
                }
            }

            while (true) {
                Map.Entry<Integer, Integer> suf = tm.ceilingEntry(left);
                if (suf != null) {
                    int sufLeft = suf.getKey(), sufRight = suf.getValue();
                    if (sufLeft <= right) {
                        int sufCount = sufRight - sufLeft + 1;
                        cnt -= sufCount;
                        tm.remove(sufLeft);
                        right = Math.max(right, sufRight);
                    } else break;
                } else break;
            }
            tm.put(left, right);
            cnt += right - left + 1;
        }

        public int count() {
            return cnt;
        }
    }
}
