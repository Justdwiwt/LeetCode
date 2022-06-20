package main.java;

public class Solution_2241 {
    static class ATM {
        long[] notes = new long[5];
        int[] diff = new int[]{20, 50, 100, 200, 500};

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < 5; i++)
                notes[i] += banknotesCount[i];
        }

        public int[] withdraw(int amount) {
            int[] res = new int[5];
            for (int i = 4; i >= 0; i--) {
                res[i] = (int) Math.min(notes[i], amount / diff[i]);
                amount -= diff[i] * res[i];
            }
            if (amount != 0)
                return new int[]{-1};
            for (int i = 0; i < 5; i++)
                notes[i] = notes[i] - res[i];
            return res;
        }
    }
}
