package main.java;

import java.util.*;

public class Solution_1338 {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(arr).forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        int temp = 0, res = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            temp += entry.getValue();
            res++;
            if (temp >= arr.length / 2) break;
        }
        return res;
    }
}
