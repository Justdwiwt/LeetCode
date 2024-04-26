package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_96 {
    Map<Integer, Integer> memory = new HashMap<>();

    public int numTrees(int n) {
        return helper(1, n);
    }

    public int helper(int begin, int end) {
        if (memory.containsKey(end - begin))
            return memory.get(end - begin);
        if (begin > end)
            return 1;
        int sum = 0;
        for (int i = begin; i <= end; i++) {
            int leftSize = helper(begin, i - 1);
            int rightSize = helper(i + 1, end);
            sum += leftSize * rightSize;
        }
        memory.put(end - begin, sum);
        return sum;
    }
}
