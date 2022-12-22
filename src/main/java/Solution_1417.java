package main.java;

public class Solution_1417 {
    public String reformat(String s) {
        StringBuilder digitSB = new StringBuilder();
        StringBuilder charSB = new StringBuilder();

        for (char c : s.toCharArray())
            if (Character.isDigit(c)) digitSB.append(c);
            else if (Character.isLetter(c)) charSB.append(c);

        if (Math.abs(digitSB.length() - charSB.length()) > 1) return "";

        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        while (i < digitSB.length() && j < charSB.length()) {
            if (digitSB.length() >= charSB.length()) {
                sb.append(digitSB.charAt(i++));
                sb.append(charSB.charAt(j++));
            } else {
                sb.append(charSB.charAt(j++));
                sb.append(digitSB.charAt(i++));
            }
        }

        if (digitSB.length() > charSB.length()) sb.append(digitSB.charAt(i));
        else if (charSB.length() > digitSB.length()) sb.append(charSB.charAt(j));

        return sb.toString();
    }
}
