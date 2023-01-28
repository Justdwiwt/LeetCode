package main.java;

import java.util.stream.IntStream;

public class Solution_1275 {
    public String tictactoe(int[][] moves) {
        int[][] res = new int[3][3];
        IntStream.range(0, moves.length).forEach(i -> res[moves[i][0]][moves[i][1]] = i % 2 == 0 ? 1 : 2);
        if (isVictory(res, 1)) return "A";
        else if (isVictory(res, 2)) return "B";
        return moves.length < 9 ? "Pending" : "Draw";
    }

    private static boolean isVictory(int[][] res, int player) {
        return res[0][0] == res[0][1] && res[0][1] == res[0][2] && res[0][2] == player
                || res[1][0] == res[1][1] && res[1][1] == res[1][2] && res[1][2] == player
                || res[2][0] == res[2][1] && res[2][1] == res[2][2] && res[2][2] == player
                || res[0][0] == res[1][0] && res[1][0] == res[2][0] && res[2][0] == player
                || res[0][1] == res[1][1] && res[1][1] == res[2][1] && res[2][1] == player
                || res[0][2] == res[1][2] && res[1][2] == res[2][2] && res[2][2] == player
                || res[0][0] == res[1][1] && res[1][1] == res[2][2] && res[2][2] == player
                || res[0][2] == res[1][1] && res[1][1] == res[2][0] && res[2][0] == player;
    }
}
