package main.java;

public class Solution_2591 {
    public int distMoney(int money, int children) {
        int cnt = (money - children) / 7;
        if (money > children * 8) return children - 1;
        if (money - children < 0) return -1;
        if (cnt == children - 1 && money - cnt * 8 == 4) return cnt - 1;
        else return cnt;
    }
}
