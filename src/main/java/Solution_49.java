package main.java;

import java.util.*;

public class Solution_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strToListMap = new HashMap<>();
        Arrays.stream(strs).forEach(str -> {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            strToListMap.computeIfAbsent(String.valueOf(chars), key -> new ArrayList<>()).add(str);
        });
        return new ArrayList<>(strToListMap.values());
    }
}
