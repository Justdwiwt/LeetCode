package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_352 {
    static class SummaryRanges {
        List<Integer> list;

        public SummaryRanges() {
            list = new ArrayList<>();
        }

        public void addNum(int val) {
            list.add(val);
        }

        public int[][] getIntervals() {
            if (list.size() == 1) return new int[][]{{list.get(0), list.get(0)}};
            Collections.sort(list);
            List<int[]> arr = new ArrayList<>();
            int l = list.get(0);
            for (int i = 1; i < list.size(); i++)
                if (list.get(i) - list.get(i - 1) > 1) {
                    arr.add(new int[]{l, list.get(i - 1)});
                    l = list.get(i);
                }
            arr.add(new int[]{l, list.get(list.size() - 1)});
            return arr.toArray(new int[arr.size()][]);
        }
    }
}
