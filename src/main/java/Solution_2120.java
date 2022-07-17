package main.java;

public class Solution_2120 {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int j = i, x = startPos[0], y = startPos[1];
            while (j < s.length()
                    && (x += s.charAt(j) == 'U' ? -1 : s.charAt(j) == 'D' ? 1 : 0) >= 0
                    && x < n
                    && (y += s.charAt(j) == 'L' ? -1 : s.charAt(j) == 'R' ? 1 : 0) >= 0
                    && y < n) {
                j++;
                res[i]++;
            }
        }
        return res;
    }
}
