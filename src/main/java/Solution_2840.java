package main.java;

import java.util.Arrays;

public class Solution_2840 {
    public boolean checkStrings(String s1, String s2) {
        return check(s1, s2, 0) && check(s1, s2, 1);
    }

    boolean check(String s1, String s2, int start) {
        int[] count = new int[26];
        for (int i = start; i < s1.length(); i += 2) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        return Arrays.equals(count, new int[26]);
    }
}
