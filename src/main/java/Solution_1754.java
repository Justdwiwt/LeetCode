package main.java;

public class Solution_1754 {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length())
            sb.append(word1.substring(i).compareTo(word2.substring(j)) >= 0 ? word1.charAt(i++) : word2.charAt(j++));
        return sb.toString();
    }
}
