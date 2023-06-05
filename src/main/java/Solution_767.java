package main.java;

import java.util.stream.IntStream;

public class Solution_767 {
    public String reorganizeString(String S) {
        int len = S.length();
        int[] cnt = new int[26];
        IntStream.range(0, len).forEach(i -> ++cnt[S.charAt(i) - 'a']);
        char[] res = new char[len];
        int idx = 0, preIdx = -1, t;
        while (idx < len) {
            t = getIdx(cnt, preIdx);
            if (t == -1) return "";
            --cnt[t];
            res[idx++] = (char) ('a' + t);
            preIdx = t;
        }
        return new String(res);
    }

    private int getIdx(int[] cnt, int preIdx) {
        int maxIdx = -1, maxVal = 0;
        for (int i = 0; i < cnt.length; ++i)
            if (i != preIdx && cnt[i] > maxVal) {
                maxIdx = i;
                maxVal = cnt[i];
            }
        return maxIdx;
    }
}
