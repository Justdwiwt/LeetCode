package main.java;

public class Solution_1190 {
    public String reverseParentheses(String s) {
        StringBuilder res = new StringBuilder(s);
        int l, r;
        while ((l = res.lastIndexOf("(")) != -1) {
            r = res.indexOf(")", l);
            StringBuilder sb = new StringBuilder(res.substring(l + 1, r));
            res.replace(l, r + 1, sb.reverse().toString());
        }
        return res.toString();
    }
}
