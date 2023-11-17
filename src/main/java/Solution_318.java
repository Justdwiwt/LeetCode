package main.java;

public class Solution_318 {
    public int maxProduct(String[] words) {
        int[] nums = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            for (int j = 0; j < s.length(); j++) nums[i] |= 1 << (s.charAt(j) - 'a');
        }
        int res = 0;
        for (int i = 0; i < words.length; i++)
            for (int j = i + 1; j < words.length; j++)
                if ((nums[i] & nums[j]) == 0) res = Math.max(res, words[i].length() * words[j].length());
        return res;
    }
}
