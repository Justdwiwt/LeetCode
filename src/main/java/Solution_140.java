package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_140 {
    List<String> res = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        dfs(s, wordDict, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(String s, List<String> wordDict, List<String> path, int index) {
        if (index == s.length()) {
            res.add(String.join(" ", path));
            return;
        }
        IntStream.rangeClosed(index, s.length()).filter(i -> wordDict.contains(s.substring(index, i))).forEach(i -> {
            path.add(s.substring(index, i));
            dfs(s, wordDict, path, i);
            path.remove(path.size() - 1);
        });
    }
}
