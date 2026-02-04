package main.java;

public class Solution_3014 {
    public int minimumPushes(String word) {
        int length = word.length();
        if (length <= 8) return length * 1;
        if (length <= 16) return 8 + (length - 8) * 2;
        if (length <= 24) return 8 + 16 + (length - 16) * 3;
        return 8 + 16 + 24 + (length - 24) * 4;
    }
}
