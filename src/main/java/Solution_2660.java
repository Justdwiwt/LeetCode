package main.java;

public class Solution_2660 {
    public int isWinner(int[] player1, int[] player2) {
        int a = -3, b = -3, n = 0, m = 0;
        for (int i = 0; i < player1.length; i++) {
            n += (i - a < 3) ? player1[i] << 1 : player1[i];
            m += (i - b < 3) ? player2[i] << 1 : player2[i];
            if (player1[i] == 10) a = i;
            if (player2[i] == 10) b = i;
        }
        return n > m ? 1 : n < m ? 2 : 0;
    }
}
