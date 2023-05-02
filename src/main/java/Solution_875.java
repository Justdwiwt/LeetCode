package main.java;

import java.util.Arrays;

public class Solution_875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        while (left < right) {
            int mid = (left + right) >>> 1;
            int needHour = Arrays.stream(piles).map(pile -> (pile - 1) / mid + 1).sum();
            if (needHour > h) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
