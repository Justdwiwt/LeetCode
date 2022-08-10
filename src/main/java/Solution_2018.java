package main.java;

public class Solution_2018 {
    public boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[][] rotated = new char[n][m];
        for (int j = 0; j < n; j++)
            for (int i = 0; i < m; i++)
                rotated[j][i] = board[i][j];
        return helper(board, word) || helper(rotated, word);
    }

    private boolean helper(char[][] board, String word) {
        for (char[] row : board) {
            String[] split = new String(row).split("#");
            String[] words = new String[]{word, new StringBuilder(word).reverse().toString()};
            for (String wd : words)
                for (String str : split)
                    if (str.length() == wd.length()) {
                        int cnt = 0;
                        while (cnt < str.length() && (str.charAt(cnt) == ' ' || str.charAt(cnt) == wd.charAt(cnt)))
                            cnt++;
                        if (cnt == str.length())
                            return true;
                    }
        }
        return false;
    }
}
