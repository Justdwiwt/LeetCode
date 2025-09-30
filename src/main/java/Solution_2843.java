package main.java;

import java.util.stream.IntStream;

public class Solution_2843 {
    public int countSymmetricIntegers(int low, int high) {
        return (int) IntStream.rangeClosed(low, high).filter(this::check).count();
    }

    private boolean check(int value) {
        if ((1 <= value && value <= 9) || (100 <= value && value <= 999)) {
            return false;
        }
        char[] charArray = String.valueOf(value).toCharArray();
        int leftSum = 0, rightSum = 0;
        for (int left = 0, right = charArray.length - 1; left < right; left++, right--) {
            leftSum += charArray[left] - '0';
            rightSum += charArray[right] - '0';
        }
        return leftSum == rightSum;
    }
}
