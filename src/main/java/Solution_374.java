package main.java;

public class Solution_374 {
    int guess(int num) {
        return 0;
    }

    public int guessNumber(int n) {
        int l = 1, r = n;
        while (true) {
            int mid = l + (r - l) / 2;
            int tmp = guess(mid);
            if (tmp == -1) r = mid;
            else if (tmp == 1) l = mid + 1;
            else return mid;
        }
    }
}
