package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        List<String> wordList = Arrays.asList(words);
        Collections.sort(wordList);
        int wordsLen = words.length;
        int wordLen = words[0].length();
        int wordsLenSum = wordsLen * wordLen;
        if (s.length() < wordsLenSum) return res;
        for (int i = 0; i <= s.length() - wordsLenSum; i++) {
            String subStr = s.substring(i, i + wordsLenSum);
            List<String> tmpList = new ArrayList<>();
            for (int k = 0; k < subStr.length(); k = k + wordLen) tmpList.add(subStr.substring(k, k + wordLen));
            Collections.sort(tmpList);
            if (tmpList.equals(wordList)) res.add(i);
        }
        return res;
    }
}
