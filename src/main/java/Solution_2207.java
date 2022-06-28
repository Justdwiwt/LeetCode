package main.java;

public class Solution_2207 {
    public long maximumSubsequenceCount(String text, String pattern) {
        char a = pattern.charAt(0), b = pattern.charAt(1);
        long num1 = 0, num2 = 0, res = 0;
        for (char ch : text.toCharArray()) {
            if (ch == b) {
                num2++;
                res += num1;
            }
            if (ch == a) num1++;
        }
        return res + Math.max(num1, num2);
    }
}
