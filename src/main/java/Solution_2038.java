package main.java;

public class Solution_2038 {
    public boolean winnerOfGame(String colors) {
        int cnt = 0;
        for (int i = 0; i < colors.length() - 2; i++) {
            if (colors.startsWith("AAA", i)) cnt++;
            if (colors.startsWith("BBB", i)) cnt--;
        }
        return cnt > 0;
    }
}
