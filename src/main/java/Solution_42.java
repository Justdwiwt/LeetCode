package main.java;

public class Solution_42 {
    public int trap(int[] height) {
        int total = 0;
        int left = 0;
        int right = height.length - 1;
        int minHeight = 0;
        while (left < right) {
            int leftNum = height[left];
            if (leftNum <= minHeight) {
                total = total + (minHeight - leftNum);
                left++;
                continue;
            }
            int rightNum = height[right];
            if (rightNum <= minHeight) {
                total = total + (minHeight - rightNum);
                right--;
                continue;
            }
            minHeight = Math.min(leftNum, rightNum);
        }
        return total;
    }
}
