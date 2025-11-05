package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_2900 {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        int pre = groups[0];
        for (int i = 1; i < groups.length; i++)
            if (groups[i] != pre) {
                res.add(words[i]);
                pre = groups[i];
            }
        return res;
    }
}
