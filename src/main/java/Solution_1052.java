package main.java;

public class Solution_1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int x) {
        int sum = 0, len = customers.length;
        for (int i = 0; i < len; i++)
            if (grumpy[i] == 0) {
                sum += customers[i];
                customers[i] = 0;
            }
        int num = customers[0];
        int maxval = customers[0];
        for (int i = 1; i < len; i++) {
            num = i < x ? num + customers[i] : num + customers[i] - customers[i - x];
            maxval = Math.max(maxval, num);
        }
        return (sum + maxval);
    }
}
