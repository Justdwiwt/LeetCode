package main.java;

import java.util.List;
import java.util.stream.IntStream;

public class Solution_1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res;
        int idx = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
        res = (int) IntStream.range(0, items.size()).filter(i -> items.get(i).get(idx).equals(ruleValue)).count();
        return res;
    }
}
