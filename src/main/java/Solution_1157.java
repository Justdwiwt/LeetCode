package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_1157 {
    static class MajorityChecker {
        Map<Integer, List<Integer>> map = new HashMap<>();

        public MajorityChecker(int[] arr) {
            IntStream.range(0, arr.length).forEach(i -> {
                if (!map.containsKey(arr[i]))
                    map.put(arr[i], new ArrayList<>());
                map.get(arr[i]).add(i);
            });
        }

        public int query(int left, int right, int threshold) {
            int total = right - left + 1;
            int amount;
            for (Integer i : map.keySet()) {
                amount = getLength(map.get(i), left, right);
                if (amount >= threshold) return i;
                total -= amount;
                if (total < threshold) break;
            }
            return -1;
        }

        public int getLength(List<Integer> list, int left, int right) {
            if (list.get(0) > right || list.get(list.size() - 1) < left) return 0;
            int lIdx = getLIndex(list, left, right);
            if (lIdx == -1) return 0;
            int rIdx = getRIndex(list, right);
            return rIdx - lIdx + 1;
        }

        public int getLIndex(List<Integer> list, int left, int right) {
            int start = 0;
            int end = list.size() - 1;
            int mid;
            while (start < end) {
                mid = (end - start) / 2 + start;
                if (list.get(mid) >= left) end = mid;
                else start = mid + 1;
            }
            if (list.get(end) > right) return -1;
            return end;
        }

        public int getRIndex(List<Integer> list, int right) {
            int start = 0;
            int end = list.size() - 1;
            if (list.get(end) <= right) return end;
            int mid;
            while (start < end) {
                mid = (end - start) / 2 + start;
                if (list.get(mid) > right) end = mid;
                else start = mid + 1;
            }
            return end - 1;
        }
    }
}
