package main.java;

public class Solution_1358 {
    public int numberOfSubstrings(String s) {
        int res = 0;
        int[] counts = new int[3];
        char[] chars = s.toCharArray();
        for (int left = 0, right = 0; right < chars.length; right++) {
            counts[chars[right] - 'a']++;
            while (counts[0] > 0 && counts[1] > 0 && counts[2] > 0) {
                counts[chars[left++] - 'a']--;
                res += chars.length - right;
            }
        }
        return res;
    }
}
