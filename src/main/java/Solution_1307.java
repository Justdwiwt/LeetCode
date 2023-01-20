package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_1307 {
    boolean[] used;
    boolean res = false;
    int rlength;
    int[] wordLength;
    Map<Character, Integer> map = new HashMap<>();

    public boolean isSolvable(String[] words, String result) {
        used = new boolean[10];
        rlength = result.length();
        wordLength = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            wordLength[i] = words[i].length();
            if (wordLength[i] > rlength) return false;
        }
        dfs(words, 0, result, 1, 0);
        return res;
    }

    public void dfs(String[] words, int idx, String result, int pos, int sum) {
        if (pos > rlength) {
            if (sum == 0) res = true;
            return;
        }
        if (idx == words.length) {
            char c = result.charAt(rlength - pos);
            int tar = sum % 10;
            if (!used[tar] && !map.containsKey(c)) {
                if (tar == 0 && pos == rlength) return;
                used[tar] = true;
                map.put(c, tar);
                dfs(words, 0, result, pos + 1, sum / 10);
                map.remove(c);
                used[tar] = false;
            } else if (map.getOrDefault(c, -2) == tar)
                dfs(words, 0, result, pos + 1, sum / 10);
        } else {
            String word = words[idx];
            if (pos > wordLength[idx]) {
                dfs(words, idx + 1, result, pos, sum);
                return;
            }
            char c = word.charAt(wordLength[idx] - pos);
            if (map.containsKey(c)) {
                if (wordLength[idx] == pos && map.get(c) == 0) return;
                dfs(words, idx + 1, result, pos, sum + map.get(c));
            } else {
                IntStream.range(wordLength[idx] - pos == 0 ? (wordLength[idx] == 1 ? 0 : 1) : 0, 10).filter(i -> !used[i]).forEach(i -> {
                    used[i] = true;
                    map.put(c, i);
                    dfs(words, idx + 1, result, pos, sum + i);
                    map.remove(c);
                    used[i] = false;
                });
            }
        }
    }
}
