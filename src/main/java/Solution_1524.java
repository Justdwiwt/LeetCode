package main.java;

public class Solution_1524 {
    public int numOfSubarrays(int[] arr) {
        int cnt1 = 0, cnt, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt = i;
            if ((arr[i] & 1) == 1) cnt1 = cnt + 1 - cnt1;
            sum = (sum + cnt1) % 1000000007;
        }
        return sum;
    }
}
