package main.java;

public class Solution_2180 {
    public int countEven(int num) {
        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            int sum = 0, tmp = i;
            while (tmp != 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if (sum % 2 == 0) cnt++;
        }
        return cnt;
    }
}
