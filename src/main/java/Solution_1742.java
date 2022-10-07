package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0, tmp = i;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            int val = map.getOrDefault(sum, 0);
            map.put(sum, val + 1);
            res = Math.max(res, map.get(sum));
        }
        return res;
    }
}
