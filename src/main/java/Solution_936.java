package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_936 {
    public int[] movesToStamp(String _stamp, String _target) {
        List<Integer> res = new ArrayList<>();
        char[] stamp = _stamp.toCharArray();
        char[] target = _target.toCharArray();
        while (unStamp(target, stamp, res)) {
        }
        if (!isValid(target)) return new int[0];
        Collections.reverse(res);
        return res.stream().mapToInt(i -> i).toArray();
    }

    private boolean unStamp(char[] target, char[] stamp, List<Integer> ans) {
        boolean changed = false;
        for (int i = 0; i + stamp.length <= target.length; i++)
            if (isMatch(target, i, stamp)) {
                markStar(target, i, stamp.length);
                ans.add(i);
                changed = true;
            }
        return changed;
    }

    private void markStar(char[] target, int i, int len) {
        IntStream.range(0, len).forEach(j -> target[i + j] = '*');
    }

    private boolean isMatch(char[] target, int i, char[] stamp) {
        boolean changed = false;
        for (int j = 0; j < stamp.length; j++)
            if (target[i + j] == '*') {
            } else if (target[i + j] == stamp[j]) changed = true;
            else return false;
        return changed;
    }

    private boolean isValid(char[] target) {
        for (char c : target)
            if (c != '*') return false;
        return true;
    }
}
