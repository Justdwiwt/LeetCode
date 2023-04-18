package main.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_916 {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] target = new int[26];
        for (String w2 : words2) {
            int[] tmp = new int[26];
            for (char ch : w2.toCharArray()) tmp[ch - 'a']++;
            IntStream.range(0, 26).filter(i -> tmp[i] > target[i]).forEach(i -> target[i] = tmp[i]);
        }
        return IntStream.range(0, words1.length).filter(i -> check(words1[i], target)).mapToObj(i -> words1[i]).collect(Collectors.toList());
    }

    private boolean check(String str1, int[] t) {
        int[] arr = new int[26];
        for (char ch : str1.toCharArray()) arr[ch - 'a']++;
        return IntStream.range(0, 26).noneMatch(i -> arr[i] < t[i]);
    }
}
