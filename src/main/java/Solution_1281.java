package main.java;

public class Solution_1281 {
    public int subtractProductAndSum(int n) {
        int multi = 1, sum = 0;
        while (n != 0) {
            sum += n % 10;
            multi *= n % 10;
            n /= 10;
        }
        return multi - sum;
    }
}
