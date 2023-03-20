package main.java;

public class Solution_1007 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int N = tops.length;
        int cnt = (1 << 7) - 1;
        for (int i = 0; i < N; i++) {
            int curr = (1 << tops[i] - 1) | (1 << bottoms[i] - 1);
            cnt &= curr;
            if (cnt == 0) return -1;
        }
        int target = 1;
        for (int i = 0; i < 6; i++)
            if ((cnt & (1 << i)) > 0) {
                target = i + 1;
                break;
            }
        int up = 0;
        int down = 0;
        for (int i = 0; i < N; i++) {
            if (tops[i] != target) up++;
            if (bottoms[i] != target) down++;
        }
        return Math.min(up, down);
    }
}
