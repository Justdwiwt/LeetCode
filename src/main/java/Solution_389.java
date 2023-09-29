package main.java;

public class Solution_389 {
    public char findTheDifference(String s, String t) {
        return (char) (t.chars().sum() - s.chars().sum());
    }
}
