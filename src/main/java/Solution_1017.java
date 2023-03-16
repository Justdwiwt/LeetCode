package main.java;

public class Solution_1017 {
    public String baseNeg2(int n) {
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            res.insert(0, (n & 1));
            n = -(n >> 1);
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
