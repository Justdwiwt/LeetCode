package main.java;

public class Solution_657 {
    public boolean judgeCircle(String moves) {
        int[] cnt = new int[26];
        for (char c : moves.toCharArray()) cnt[c - 'A']++;
        return cnt['L' - 'A'] == cnt['R' - 'A'] && cnt['U' - 'A'] == cnt['D' - 'A'];
    }
}
