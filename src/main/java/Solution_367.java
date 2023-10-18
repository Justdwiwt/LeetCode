package main.java;

public class Solution_367 {
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (mid < num / mid) low = mid + 1;
            else high = mid;
        }
        return high * high == num;
    }
}
