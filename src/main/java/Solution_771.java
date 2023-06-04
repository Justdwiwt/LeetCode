package main.java;

public class Solution_771 {
    public int numJewelsInStones(String J, String S) {
        String a = "[^" + J + ']';
        S = S.replaceAll(a, "");
        return S.length();
    }
}
