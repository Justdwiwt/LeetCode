package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_2947 {
    public int beautifulSubstrings(String s, int k) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' || s.charAt(j) == 'o' || s.charAt(j) == 'u')
                    map.put('1', map.getOrDefault('1', 0) + 1);
                else map.put('2', map.getOrDefault('2', 0) + 1);
                Integer a = map.getOrDefault('1', 0);
                Integer b = map.getOrDefault('2', 0);
                if (a.equals(b) && (a * b) % k == 0) count++;
            }
        }
        return count;
    }
}
