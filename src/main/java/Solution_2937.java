package main.java;

public class Solution_2937 {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int minL = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        for (int i = minL; i > 0; i--)
            if (s1.substring(0, i).equals(s2.substring(0, i)) && s1.substring(0, i).equals(s3.substring(0, i)))
                return s1.length() + s2.length() + s3.length() - i * 3;
        return -1;
    }
}
