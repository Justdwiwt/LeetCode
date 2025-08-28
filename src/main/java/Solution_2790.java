package main.java;

import java.util.Collections;
import java.util.List;

public class Solution_2790 {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        Collections.sort(usageLimits);
        long available = 0;
        int group = 0;
        for (int limit : usageLimits) {
            available += limit;
            if (available > group) {
                group++;
                available -= group;
            }
        }
        return group;
    }
}
