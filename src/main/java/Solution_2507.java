package main.java;

public class Solution_2507 {
    public int smallestValue(int n) {
        if (n == 4) return 4;
        int num = 0;
        int i = 2;
        while (n > 1) {
            if (n == i && num == 0) return i;
            if (n % i == 0) {
                num += i;
                n /= i;
            } else i++;
        }
        return smallestValue(num);
    }
}
