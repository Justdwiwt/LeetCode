package main.java;

import java.util.HashMap;
import java.util.stream.IntStream;

public class Solution_464 {
    HashMap<Integer, Boolean> map = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int tmp = IntStream.rangeClosed(1, maxChoosableInteger).sum();
        if (tmp < desiredTotal) return false;
        return dfs(maxChoosableInteger, 0, desiredTotal, 0);
    }

    public boolean dfs(int maxChoosableInteger, int usedInteger, int desiredTotal, int curTotal) {
        if (!map.containsKey(usedInteger)) {
            boolean ret = false;
            for (int x = 0; x < maxChoosableInteger; x++)
                if (((usedInteger >> x) & 1) == 0) {
                    if (curTotal + x + 1 >= desiredTotal) {
                        ret = true;
                        break;
                    }

                    if (!dfs(maxChoosableInteger, usedInteger | (1 << x), desiredTotal, curTotal + x + 1)) {
                        ret = true;
                        break;
                    }
                }
            map.put(usedInteger, ret);
        }
        return map.get(usedInteger);
    }
}
