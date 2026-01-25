package main.java;

public class Solution_3003 {
    private int seg = 1, mask = 0, size = 0;

    public int maxPartitionsAfterOperations(String S, int k) {
        if (k == 26) {
            return 1;
        }

        char[] s = S.toCharArray();
        int n = s.length;
        int[] sufSeg = new int[n + 1];
        int[] sufMask = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            update(s[i], k);
            sufSeg[i] = seg;
            sufMask[i] = mask;
        }

        int ans = seg;
        seg = 1;
        mask = 0;
        size = 0;
        for (int i = 0; i < n; i++) {
            int res = seg + sufSeg[i + 1];
            int unionSize = Integer.bitCount(mask | sufMask[i + 1]);
            if (unionSize < k) {
                res--;
            } else if (unionSize < 26 && size == k && Integer.bitCount(sufMask[i + 1]) == k) {
                res++;
            }
            ans = Math.max(ans, res);
            update(s[i], k);
        }
        return ans;
    }

    private void update(char c, int k) {
        int bit = 1 << (c - 'a');
        if ((mask & bit) != 0) {
            return;
        }
        size++;
        if (size > k) {
            seg++;
            mask = bit;
            size = 1;
        } else {
            mask |= bit;
        }
    }
}
