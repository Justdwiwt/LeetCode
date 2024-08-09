package main.java;

public class Solution_11 {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int n = height.length;
        int right = n - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                max = Math.max(max, (right - left) * height[left]);
                left++;
            } else {
                max = Math.max(max, (right - left) * height[right]);
                right--;
            }
        }
        return max;
    }
}
