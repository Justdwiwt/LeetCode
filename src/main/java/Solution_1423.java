package main.java;

import java.util.Arrays;

public class Solution_1423 {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length, sum = Arrays.stream(cardPoints).sum();
        int min = Integer.MAX_VALUE, temp = 0;
        int length = len - k;
        for (int i = 0; i < len; i++) {
            temp += cardPoints[i];
            if (i >= length) temp -= cardPoints[i - length];
            if (i >= length - 1) min = Math.min(min, temp);
        }
        return sum - min;
    }
}
