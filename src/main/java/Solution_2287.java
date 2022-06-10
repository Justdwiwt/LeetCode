package main.java;

public class Solution_2287 {
    public int rearrangeCharacters(String s, String target) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (char c : s.toCharArray()) arr1[c - 'a']++;
        for (char c : target.toCharArray()) arr2[c - 'a']++;

        int res = Integer.MAX_VALUE;

        for (char c : target.toCharArray()) {
            int t = arr1[c - 'a'] / arr2[c - 'a'];
            res = Math.min(res, t);
        }

        return res;
    }
}
