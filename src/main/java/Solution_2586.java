package main.java;

public class Solution_2586 {
    boolean isValid(char s) {
        return "aeiou".indexOf(s) != -1;
    }

    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for (; left <= right; left++)
            ans += isValid(words[left].charAt(0)) &&
                    isValid(words[left].charAt(words[left].length() - 1)) ? 1 : 0;
        return ans;
    }
}
