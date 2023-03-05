package main.java;

import java.util.TreeMap;

public class Solution_1053 {
    public int[] prevPermOpt1(int[] arr) {
        final int N = arr.length;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        Integer change;
        for (int i = N - 1; i >= 0; i--) {
            change = tm.lowerKey(arr[i]);
            if (change != null) {
                int index = tm.get(change);
                arr[index] = arr[i];
                arr[i] = change;
                break;
            }
            tm.put(arr[i], i);
        }
        return arr;
    }
}
