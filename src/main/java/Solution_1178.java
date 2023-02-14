package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_1178 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> maskCount = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) mask |= (1 << (c - 'a'));
            maskCount.put(mask, maskCount.getOrDefault(mask, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (String p : puzzles) {
            int ansP = 0;
            int containFirstLetter = 1 << (p.charAt(0) - 'a');
            int set = 0;
            for (char c : p.toCharArray()) set |= 1 << (c - 'a');
            int subset = set;
            while (subset != 0) {
                if ((subset & containFirstLetter) > 0) ansP += maskCount.getOrDefault(subset, 0);
                subset = (subset - 1) & set;
            }
            ans.add(ansP);
        }
        return ans;
    }
}
