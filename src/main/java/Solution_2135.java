package main.java;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution_2135 {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<String> st = Arrays.stream(startWords)
                .parallel()
                .map(e -> {
                    char[] ch = e.toCharArray();
                    Arrays.sort(ch);
                    return String.valueOf(ch);
                })
                .collect(Collectors.toSet());

        return Arrays.stream(targetWords)
                .parallel()
                .mapToInt(e -> {
                    char[] ch = e.toCharArray();
                    Arrays.sort(ch);
                    String t = String.valueOf(ch);

                    int[] arr = new int[26];
                    for (char c : ch)
                        arr[c - 'a']++;

                    for (int i = 0; i < 26; i++) {
                        if (arr[i] != 1) continue;

                        char c = (char) (i + 'a');
                        int idx = t.indexOf(c);

                        if (st.contains(t.substring(0, idx) + t.substring(idx + 1)))
                            return 1;
                    }
                    return 0;
                })
                .reduce(0, Integer::sum);
    }
}
