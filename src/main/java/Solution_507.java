package main.java;

public class Solution_507 {
    public boolean checkPerfectNumber(int num) {
        if (num < 4) return false;
        int cur = 0;
        for (int i = 1; i < Math.sqrt(num); i++)
            if (num % i == 0) {
                cur += i;
                cur += num / i;
            }
        if (Math.sqrt(num) * Math.sqrt(num) == num)
            cur += Math.sqrt(num);
        return num == cur - num;
    }
}
