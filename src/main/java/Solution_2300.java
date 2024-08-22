package main.java;

public class Solution_2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] cnt = new int[100001];
        int max = 0;
        for (int x : potions) {
            ++cnt[x];
            max = Math.max(max, x);
        }
        for (int i = max - 1; i >= 1; --i) cnt[i] += cnt[i + 1];
        for (int i = 0; i < spells.length; ++i) {
            int small = (int) (success / spells[i]);
            if (success % spells[i] > 0) ++small;
            spells[i] = small > 100000 || small < 1 ? 0 : cnt[small];
        }
        return spells;
    }
}
