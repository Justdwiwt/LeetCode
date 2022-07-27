package main.java;

public class Solution_2078 {
    public int maxDistance(int[] colors) {
        int n = colors.length, c = colors[0], left = 0, right = n - 1;
        if (colors[n - 1] != c)
            return n - 1;
        while (colors[left] == c)
            left++;
        while (colors[right] == c)
            right--;
        return Math.max(Math.max(left, n - 1 - left), Math.max(right, n - 1 - right));
    }
}
