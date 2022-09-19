package main.java;

public class Solution_1832 {
    public boolean checkIfPangram(String sentence) {
        return sentence.chars().distinct().count() == 26;
    }
}
