package main.java;

import java.util.HashSet;
import java.util.Set;

public class Solution_1805 {
    public int numDifferentIntegers(String word) {
        Set<String> st = new HashSet<>();
        for (int i = 0, j = 0; i < word.length(); i++)
            if (isLetter(word.charAt(i))) {
                if (i > 0 && !isLetter(word.charAt(i - 1)))
                    st.add(getNumberStr(i, j, word));
            } else {
                if (i > 0 && isLetter(word.charAt(i - 1)))
                    j = i;
                if (i == word.length() - 1)
                    st.add(getNumberStr(i + 1, j, word));
            }
        return st.size();
    }

    private boolean isLetter(char c) {
        return Character.isLetter(c);
    }

    private String getNumberStr(int i, int j, String word) {
        String substring = word.substring(j, i);
        return substring.startsWith("0") ? substring.replaceFirst("0+", "") : substring;
    }
}
