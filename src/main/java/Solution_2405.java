package main.java;

import java.util.HashSet;
import java.util.Set;

public class Solution_2405 {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int count = 1;
        for (int right = 0; right < s.length(); right++) {
            if (set.contains(s.charAt(right))) {
                count++;
                set.clear();
            }
            set.add(s.charAt(right));
        }
        return count;
    }
}
