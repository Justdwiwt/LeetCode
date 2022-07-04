package main.java;

import java.util.LinkedList;
import java.util.List;

public class Solution_2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new LinkedList<>();
        if (finalSum % 2 == 1) return res;
        for (long i = 2; i <= finalSum; i += 2) {
            res.add(i);
            finalSum -= i;
        }
        if (finalSum > 0)
            res.add(res.remove(res.size() - 1) + finalSum);
        return res;
    }
}
