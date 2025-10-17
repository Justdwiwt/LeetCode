package main.java;

public class Solution_2863 {
    public String maximumOddBinaryNumber(String s) {
        String replace = s.replace("0", "");
        String replace1 = s.replace("1", "");
        return replace.replaceFirst("1", "") + replace1 + "1";
    }
}
