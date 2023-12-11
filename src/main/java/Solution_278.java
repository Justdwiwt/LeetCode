package main.java;

public class Solution_278 {
    boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
