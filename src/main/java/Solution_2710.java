package main.java;

public class Solution_2710 {
    public String removeTrailingZeros(String num) {
        return num.replaceAll("0+$", "");
    }
}
