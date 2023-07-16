package main.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution_592 {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public String fractionAddition(String expression) {
        Pattern pattern = Pattern.compile("([+-]?\\d+)/(\\d+)");
        Matcher matcher = pattern.matcher(expression);
        int numerator = 0, denominator = 1;
        while (matcher.find()) {
            int a = Integer.parseInt(matcher.group(1));
            int b = Integer.parseInt(matcher.group(2));
            numerator = numerator * b + denominator * a;
            denominator *= b;
            int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            numerator /= gcd;
            denominator /= gcd;
        }
        return numerator + "/" + denominator;
    }
}
