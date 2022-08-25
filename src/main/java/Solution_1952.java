package main.java;

public class Solution_1952 {
    public boolean isThree(int n) {
        int cnt = 0;
        for (int i = 2; i < n && cnt < 2; i++)
            if (n % i == 0) cnt++;
        return cnt == 1;
    }
}
