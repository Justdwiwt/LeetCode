package main.java;

public class Solution_65 {
    public boolean isNumber(String s) {
        String regex0 = "(\\d+\\.|\\d+\\.\\d+|\\.\\d+)";
        String regex1 = "(\\d+)";
        String regex2 = "([+\\-])?(" + regex0 + "|" + regex1 + ")" + "(([eE])([+\\-])?" + regex1 + ")?";
        return s.matches(regex2);
    }
}
