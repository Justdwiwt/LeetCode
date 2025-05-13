package main.java;

public class Solution_2600 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        return k > numOnes + numZeros ? numOnes - (k - numOnes - numZeros) : Math.min(numOnes, k);
    }
}
