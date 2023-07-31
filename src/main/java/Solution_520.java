package main.java;

public class Solution_520 {
    public boolean detectCapitalUse(String word) {
        return word.toUpperCase().equals(word) || word.toLowerCase().equals(word) || word.substring(1).toLowerCase().equals(word.substring(1));
    }
}
