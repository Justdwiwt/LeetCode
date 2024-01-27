package main.java;

import java.util.HashMap;

public class Solution_205 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
            }
            if (t.charAt(i) != map.get(s.charAt(i))) return false;
        }
        return true;
    }
}
