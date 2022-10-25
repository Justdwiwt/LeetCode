package main.java;

public class Solution_1668 {
    public int maxRepeating(String sequence, String word) {
        int cnt = 0;
        String tmp = word;
        while (sequence.contains(word)) {
            word += tmp;
            cnt++;
        }
        return cnt;
    }
}
