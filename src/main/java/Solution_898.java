package main.java;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution_898 {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        for (int num : arr) {
            cur = cur.stream().mapToInt(orSum -> orSum).mapToObj(orSum -> orSum | num).collect(Collectors.toSet());
            cur.add(num);
            res.addAll(cur);
        }
        return res.size();
    }
}
