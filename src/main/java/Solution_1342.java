package main.java;

public class Solution_1342 {
    public int numberOfSteps(int num) {
        int cnt = 0;
        while (num != 0) {
            num = (num % 2 != 0) ? (num - 1) : (num / 2);
            cnt++;
        }
        return cnt;
    }
}
