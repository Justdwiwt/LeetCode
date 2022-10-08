package main.java;

import java.util.stream.IntStream;

public class Solution_1737 {
    public int minCharacters(String a, String b) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        IntStream.range(0, a.length()).forEach(i -> cnt1[a.charAt(i) - 'a']++);
        IntStream.range(0, b.length()).forEach(i -> cnt2[b.charAt(i) - 'a']++);
        int maxSum = cnt1[0] + cnt2[0];
        for (int i = 1; i < 26; i++) {
            maxSum = Math.max(maxSum, cnt1[i] + cnt2[i]);
            cnt1[i] += cnt1[i - 1];
            cnt2[i] += cnt2[i - 1];
        }
        return Math.min(a.length() + b.length() - maxSum, minChange(cnt1, cnt2));
    }

    private int minChange(int[] cnt1, int[] cnt2) {
        int res1 = cnt1[25] - cnt1[0] + cnt2[0];
        int res2 = cnt2[25] - cnt2[0] + cnt1[0];
        for (int i = 1; i < 25; i++) {
            res1 = Math.min(res1, cnt1[25] - cnt1[i] + cnt2[i]);
            res2 = Math.min(res2, cnt2[25] - cnt2[i] + cnt1[i]);
        }
        return Math.min(res1, res2);
    }
}
