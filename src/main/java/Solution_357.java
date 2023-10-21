package main.java;

public class Solution_357 {
    public int countNumbersWithUniqueDigits(int n) {
        // A(9,1)*A(9,n-1)+A(9,1)*A(9,n-2)+……+A(9,1)+1=9(A(9,n-1)+A(9,n-2)+……+A(9,1)+1)+1
        int res = 0;
        int tmp = 1;
        for (int i = 0; i < n; i++) {
            res += tmp;
            tmp *= (9 - i);
        }
        return res * 9 + 1;
    }
}
