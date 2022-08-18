package main.java;

import java.util.HashSet;
import java.util.Set;

public class Solution_1981 {
    public int minimizeTheDifference(int[][] mat, int target) {
        Set<Integer> set = new HashSet<>();
        set.add(target);
        for (int i = 1; i <= mat.length; i++) {
            Set<Integer> newSet = new HashSet<>();
            for (int rowNum : mat[mat.length - i])
                for (int setNum : set)
                    if (i == mat.length || setNum - rowNum >= 800 - 70 * 70 / 2)
                        newSet.add(setNum - rowNum);
            set = newSet;
        }
        return set.stream().mapToInt(Math::abs).min().orElse(0);
    }
}
