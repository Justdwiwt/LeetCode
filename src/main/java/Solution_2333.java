package main.java;

import java.util.Map;
import java.util.TreeMap;

public class Solution_2333 {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums1.length, max = Integer.MIN_VALUE;
        long sum = k1 + k2, count = 0;
        for (int i = 0; i < n; i++) {
            int tmp = Math.abs(nums1[i] - nums2[i]);
            count += tmp;
            max = Math.max(tmp, max);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        if (count <= sum) return 0;
        while (sum > 0) {
            Integer floorKey = map.floorKey(max - 1);
            Integer maxCnt = map.remove(max);
            if (floorKey == null) {
                int tmp1 = (int) (sum % maxCnt);
                int tmp2 = (int) (sum / maxCnt);
                minSumSquareDiff(tmp1, tmp2, map, max, maxCnt);
                break;
            } else {
                int maxRemove = (max - floorKey) * maxCnt;
                if (maxRemove >= sum) {
                    int tmp1 = (int) (sum % maxCnt);
                    int tmp2 = (int) (sum / maxCnt);
                    minSumSquareDiff(tmp1, tmp2, map, max, maxCnt);
                    break;
                } else {
                    int tmp1 = maxRemove % maxCnt;
                    int tmp2 = maxRemove / maxCnt;
                    max = minSumSquareDiff(tmp1, tmp2, map, max, maxCnt);
                    sum -= maxRemove;
                }
            }
        }
        long res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            long k = entry.getKey();
            res += k * k * entry.getValue();
        }
        return res;
    }

    private int minSumSquareDiff(int tmp1, int tmp2, TreeMap<Integer, Integer> map, int max, int maxCnt) {
        if (tmp1 == 0) {
            map.put(max - tmp2, maxCnt + map.getOrDefault(max - tmp2, 0));
            max = max - tmp2;
        } else {
            map.put(max - tmp2 - 1, tmp1 + map.getOrDefault(max - tmp2 - 1, 0));
            map.put(max - tmp2, maxCnt - tmp1 + map.getOrDefault(max - tmp2, 0));
            max = max - tmp2 - 1;
        }
        return max;
    }
}
