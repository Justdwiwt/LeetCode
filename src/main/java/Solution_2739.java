package main.java;

public class Solution_2739 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        return 10 * (mainTank + Math.min(additionalTank, (mainTank - 1) / 4));
    }
}
