package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> dict = IntStream.range(0, words.length).boxed().collect(Collectors.toMap(i -> words[i], i -> i, (a, b) -> b));
        for (int j = 0; j < words.length; j++) {
            String str = words[j];
            int left = 0;
            int right = 0;
            while (left <= right) {
                String tmp = str.substring(left, right);
                Integer k = dict.get(new StringBuilder(tmp).reverse().toString());
                if (k != null && k != j && isPalindrome(str.substring(left == 0 ? right : 0, left == 0 ? str.length() : left)))
                    res.add(Arrays.asList(left == 0 ? new Integer[]{j, k} : new Integer[]{k, j}));
                if (right < str.length()) right++;
                else left++;
            }
        }
        return res;
    }

    public boolean isPalindrome(String str) {
        int start = 0, end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
