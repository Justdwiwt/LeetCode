package main.java;

public class Solution_2806 {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int roundedAmount = purchaseAmount;
        int left = purchaseAmount % 10;
        int right = 10 - left;
        if (left < right) roundedAmount -= left;
        else roundedAmount += right;
        return 100 - roundedAmount;
    }
}
