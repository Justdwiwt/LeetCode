package main.java;

public class Solution_900 {
    static class RLEIterator {
        int[] encoding;
        int idx = 0;

        public RLEIterator(int[] encoding) {
            this.encoding = encoding;
        }

        public int next(int n) {
            for (; idx < encoding.length; idx += 2)
                if (n <= encoding[idx]) {
                    encoding[idx] -= n;
                    return encoding[idx + 1];
                } else {
                    n -= encoding[idx];
                }
            return -1;
        }
    }
}
