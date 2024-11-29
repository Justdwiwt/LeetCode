package main.java;

public class Solution_2417 {
    public int closestFair(int n) {
        for (int i = n; i <= Integer.MAX_VALUE; i++) {
            int len = 0, cnt = 0;
            for (int v = i; v > 0; v = v / 10) {
                ++len;
                cnt += v % 2;
            }

            if (len % 2 != 0) i = (int) (Math.pow(10, len) - 1);
            if (cnt * 2 == len) return i;
        }
        return -1;
    }
}
