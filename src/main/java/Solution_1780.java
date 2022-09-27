package main.java;

public class Solution_1780 {
    public boolean checkPowersOfThree(int n) {
        return n > 0 && n % 3 != 2 && (n < 3 || checkPowersOfThree(n / 3));
    }
}
