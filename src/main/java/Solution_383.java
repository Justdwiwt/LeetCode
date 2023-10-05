package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        int m = magazine.length();
        int n = ransomNote.length();
        IntStream.range(0, m).forEach(i -> map.put(magazine.charAt(i), map.containsKey(magazine.charAt(i)) ? map.get(magazine.charAt(i)) + 1 : 1));
        for (int i = 0; i < n; i++)
            if (!map.containsKey(ransomNote.charAt(i)) || map.get(ransomNote.charAt(i)) == 0) return false;
            else map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
        return true;
    }
}
