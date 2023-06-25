package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_691 {
    public int minStickers(String[] stickers, String target) {
        int m = stickers.length;
        int[][] mp = new int[m][26];
        Map<String, Integer> dp = new HashMap<>();
        IntStream.range(0, m).forEach(i -> {
            for (char c : stickers[i].toCharArray()) mp[i][c - 'a']++;
        });
        dp.put("", 0);
        return helper(dp, mp, target);
    }

    private int helper(Map<String, Integer> dp, int[][] mp, String target) {
        if (dp.containsKey(target)) return dp.get(target);
        int res = Integer.MAX_VALUE, n = mp.length;
        int[] tar = new int[26];
        for (char c : target.toCharArray()) tar[c - 'a']++;
        for (int[] ints : mp) {
            if (ints[target.charAt(0) - 'a'] == 0) continue;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++)
                if (tar[j] > 0)
                    for (int k = 0; k < Math.max(0, tar[j] - ints[j]); k++)
                        sb.append((char) ('a' + j));
            String s = sb.toString();
            int tmp = helper(dp, mp, s);
            if (tmp != -1) res = Math.min(res, 1 + tmp);
        }
        dp.put(target, res == Integer.MAX_VALUE ? -1 : res);
        return dp.get(target);
    }
}
