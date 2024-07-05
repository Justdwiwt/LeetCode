package main.java;

import java.util.stream.IntStream;

public class Solution_43 {
    public String multiply(String num1, String num2) {
        char[] value = new char[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--)
            for (int j = num2.length() - 1; j >= 0; j--)
                value[i + j + 1] += (char) ((num1.charAt(i) - '0') * (num2.charAt(j) - '0'));
        int carry = 0;
        for (int i = value.length - 1; i >= 0; i--) {
            value[i] += (char) carry;
            carry = value[i] / 10;
            value[i] %= 10;
        }
        int beginIndex = 0;
        while (beginIndex < value.length - 1 && value[beginIndex] == 0) beginIndex++;
        IntStream.range(beginIndex, value.length).forEach(i -> value[i] += '0');
        return new String(value, beginIndex, value.length - beginIndex);
    }
}
