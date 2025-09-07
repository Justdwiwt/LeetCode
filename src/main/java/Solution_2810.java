package main.java;

public class Solution_2810 {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char i : s.toCharArray())
            if (i == 'i') sb = sb.reverse();
            else sb.append(i);
        return sb.toString();
    }
}
