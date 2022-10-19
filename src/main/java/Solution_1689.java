package main.java;

public class Solution_1689 {
    public int minPartitions(String s) {
        for (char a = '9'; a >= '0'; a--)
            if (s.contains(String.valueOf(a)))
                return Character.digit(a, 10);
        return 0;
    }
}
