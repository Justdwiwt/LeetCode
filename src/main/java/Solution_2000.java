package main.java;

public class Solution_2000 {
    public String reversePrefix(String word, char ch) {
        return new StringBuilder(word.substring(0, word.indexOf(ch) + 1)).reverse() + word.substring(word.indexOf(ch) + 1);
    }
}
