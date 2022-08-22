package main.java;

public class Solution_1963 {
    public int minSwaps(String s) {
        int st = 0;
        for (char c : s.toCharArray())
            if ('[' == c) st++;
            else if (st > 0) st--;
        return (st + 1) / 2;
    }
}
