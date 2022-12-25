package main.java;

public class Solution_1405 {
    public String longestDiverseString(int a, int b, int c) {
        int[] remains = {a, b, c};
        StringBuilder sb = new StringBuilder();
        while (remains[0] + remains[1] + remains[2] > 0) {
            int p = -1;
            for (int i = 0; i < 3; i++)
                if (remains[i] > 0) {
                    char ch = (char) ('a' + i);
                    if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == ch && sb.charAt(sb.length() - 2) == ch)
                        continue;
                    if (p == -1 || remains[p] < remains[i]) p = i;
                }
            if (p >= 0) {
                sb.append((char) ('a' + p));
                remains[p]--;
            } else break;
        }
        return sb.toString();
    }
}
