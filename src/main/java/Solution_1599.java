package main.java;

public class Solution_1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int[] res = new int[2];
        int cur = 0;
        int cnt = 0;
        int amount = 0;
        while (cur >= 0) {
            if (cur == 0 && cnt >= customers.length) break;
            if (cnt < customers.length) cur += customers[cnt];
            if (cur > 4) {
                amount += 4 * boardingCost - runningCost;
                cur -= 4;
            } else {
                amount += cur * boardingCost - runningCost;
                cur = 0;
            }
            if (amount > res[1]) {
                res[0] = cnt;
                res[1] = amount;
            }
            cnt++;
        }
        return res[1] > 0 ? res[0] + 1 : -1;
    }
}
