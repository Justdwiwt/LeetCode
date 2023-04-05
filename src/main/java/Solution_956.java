package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_956 {
    int res;

    public int tallestBillboard(int[] rods) {
        res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = rods.length, n1 = n >> 1;
        findCom1(n1, rods, 0, 0, 0, map);
        findCom2(n, rods, n1, 0, 0, map);
        return res;
    }

    private void findCom2(int n, int[] rods, int idx, int sum, int pos, Map<Integer, Integer> map) {
        if (idx == n) {
            if (map.containsKey(-sum)) res = Math.max(res, pos + map.get(-sum));
        } else {
            findCom2(n, rods, idx + 1, sum + rods[idx], pos + rods[idx], map);
            findCom2(n, rods, idx + 1, sum - rods[idx], pos, map);
            findCom2(n, rods, idx + 1, sum, pos, map);
        }
    }

    private void findCom1(int n, int[] rods, int idx, int sum, int pos, Map<Integer, Integer> map) {
        if (idx == n) map.put(sum, Math.max(pos, map.getOrDefault(sum, 0)));
        else {
            findCom1(n, rods, idx + 1, sum + rods[idx], pos + rods[idx], map);
            findCom1(n, rods, idx + 1, sum - rods[idx], pos, map);
            findCom1(n, rods, idx + 1, sum, pos, map);
        }
    }
}
