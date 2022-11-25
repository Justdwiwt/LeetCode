package main.java;

public class Solution_1529 {
    public int minFlips(String target) {
        int cnt = 0, ans = 0;
        for (int i = 0; i < target.length(); i++)
            if (cnt % 2 != target.charAt(i) - '0') {
                cnt++;
                ans++;
            }
        return ans;
    }
}
