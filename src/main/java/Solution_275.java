package main.java;

public class Solution_275 {
    public int hIndex(int[] citations) {
        int n = citations.length, res = 0, left = 0, right = citations.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (n - mid <= citations[mid]) {
                res = n - mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return res;
    }
}
