package main.java;

public class Solution_2259 {
    public String removeDigit(String number, char digit) {
        String res = "";
        for (int i = 0; i < number.length(); i++) {
            String s = number.substring(0, i) + number.substring(i + 1);
            if (number.charAt(i) == digit && res.compareTo(s) < 0) res = s;
        }
        return res;
    }
}
