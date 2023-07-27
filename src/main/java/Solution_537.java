package main.java;

public class Solution_537 {
    public String complexNumberMultiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int i1 = num1.indexOf("+"), i2 = num2.indexOf("+");
        int a = Integer.parseInt(num1.substring(0, i1)), c = Integer.parseInt(num2.substring(0, i2));
        int b = Integer.parseInt(num1.substring(i1 + 1, n1 - 1)), d = Integer.parseInt(num2.substring(i2 + 1, n2 - 1));
        int s1 = a * c - b * d, s2 = b * c + a * d;
        return s1 + "+" + s2 + "i";
    }
}
