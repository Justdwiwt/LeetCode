package main.java;

public class Solution_32 {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        return Math.max(calc(chars, 0, 1, chars.length, '('), calc(chars, chars.length - 1, -1, -1, ')'));
    }

    private static int calc(char[] chars, int i, int flag, int end, char cTem) {
        int max = 0, sum = 0, currLen = 0, validLen = 0;
        for (; i != end; i += flag) {
            sum += (chars[i] == cTem ? 1 : -1);
            currLen++;
            if (sum < 0) {
                max = Math.max(max, validLen);
                sum = 0;
                currLen = 0;
                validLen = 0;
            } else if (sum == 0) validLen = currLen;
        }
        return Math.max(max, validLen);
    }
}
