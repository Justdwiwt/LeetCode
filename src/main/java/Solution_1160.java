package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1160 {
    public int countCharacters(String[] words, String chars) {
        int[] arr = new int[26];
        IntStream.range(0, chars.length()).forEach(i -> arr[chars.charAt(i) - 'a']++);
        int res = 0;
        int[] map = new int[26];
        for (String s : words) {
            boolean flag = true;
            Arrays.fill(map, 0);
            for (int i = 0; i < s.length(); i++) {
                map[s.charAt(i) - 'a']++;
                if (map[s.charAt(i) - 'a'] > arr[s.charAt(i) - 'a']) flag = false;
            }
            if (flag) res += s.length();
        }
        return res;
    }
}
