package main.java;

import java.util.*;

public class Solution_212 {
    static int[][] directs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        Three three = new Three(board);
        Trie trie = new Trie();
        Arrays.stream(words).filter(three::check).forEach(trie::insert);

        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                dfs(board, trie, i, j, res);
        return res;
    }

    public void dfs(char[][] board, Trie now, int i, int j, List<String> ans) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) return;
        if (!now.children.containsKey(board[i][j])) return;

        char ch = board[i][j];
        Trie nxt = now.children.get(ch);
        if (!nxt.word.isEmpty()) {
            ans.add(nxt.word);
            nxt.word = "";
        }

        if (!nxt.children.isEmpty()) {
            board[i][j] = '#';
            Arrays.stream(directs).forEach(direct -> dfs(board, nxt, i + direct[0], j + direct[1], ans));
            board[i][j] = ch;
        }

        if (nxt.children.isEmpty()) now.children.remove(ch);
    }
}

class Trie {
    String word;
    Map<Character, Trie> children;

    public Trie() {
        this.word = "";
        this.children = new HashMap<>();
    }

    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) cur.children.put(c, new Trie());
            cur = cur.children.get(c);
        }
        cur.word = word;
    }
}

class Three {
    static int[][] directs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Set<String> dict;

    public Three(char[][] board) {
        dict = new HashSet<>();
        char[] choose = new char[3];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                dfs(board, i, j, 0, choose);
    }

    void dfs(char[][] board, int i, int j, int now, char[] choose) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) return;
        if (board[i][j] == '#') return;
        char ch = board[i][j];
        choose[now] = ch;
        if (now == choose.length - 1) dict.add(String.valueOf(choose));
        else {
            board[i][j] = '#';
            Arrays.stream(directs).forEach(direct -> dfs(board, i + direct[0], j + direct[1], now + 1, choose));
            board[i][j] = ch;
        }
    }

    static int[] checkPoint = {10, 3, 8, 5};

    public boolean check(String word) {
        return Arrays.stream(checkPoint).noneMatch(p -> word.length() >= p && !dict.contains(word.substring(p - 3, p)));
    }
}
