package main.java;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solution_2570 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Arrays.stream(nums1).forEach(num -> map.put(num[0], num[1]));
        Arrays.stream(nums2).forEach(num -> map.put(num[0], map.getOrDefault(num[0], 0) + num[1]));
        int[][] res = new int[map.size()][2];
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            res[count][0] = entry.getKey();
            res[count][1] = entry.getValue();
            count++;
        }
        return res;
    }
}
