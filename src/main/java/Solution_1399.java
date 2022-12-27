package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_1399 {
    public int countLargestGroup(int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int sum = 0, num = i;
            while (num != 0) {
                sum = sum + num % 10;
                num = num / 10;
            }
            if (!map.containsKey(sum))
                map.put(sum, new ArrayList<>());
            List<Integer> list = map.get(sum);
            list.add(i);
        }
        int max = 0;
        for (List<Integer> list : map.values())
            max = Math.max(max, list.size());
        int res = 0;
        for (List<Integer> list : map.values())
            res = list.size() == max ? res + 1 : res;
        return res;
    }
}
