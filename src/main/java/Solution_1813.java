package main.java;

public class Solution_1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int len1 = words1.length, len2 = words2.length;
        if (len1 > len2) {
            int temp = len2;
            len2 = len1;
            len1 = temp;
            String[] words = words1;
            words1 = words2;
            words2 = words;
        }
        int i = 0, j = 0;
        while (i < len1 && words1[i].equals(words2[i])) i++;
        while (j < len1 && words1[len1 - 1 - j].equals(words2[len2 - 1 - j])) j++;
        return i + j >= len1;
    }
}
