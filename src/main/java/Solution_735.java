package main.java;

import java.util.Arrays;

public class Solution_735 {
    public int[] asteroidCollision(int[] asteroids) {
        int top = -1, n = asteroids.length;
        int[] stack = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = asteroids[i];
            if (top != -1 && stack[top] > 0 && cur < 0) {
                if (stack[top] + cur > 0) continue;
                else if (stack[top] + cur < 0) i--;
                top--;
            } else stack[++top] = cur;
        }
        return Arrays.copyOfRange(stack, 0, top + 1);
    }
}
