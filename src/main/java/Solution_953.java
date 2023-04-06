package main.java;

public class Solution_953 {
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++)
            for (int j = 0, len = words[i].length(); j < len; j++) {
                if (j >= words[i + 1].length()) return false;
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    if (order.indexOf(words[i].charAt(j)) > order.indexOf(words[i + 1].charAt(j))) return false;
                    break;
                }
            }
        return true;
    }
}
