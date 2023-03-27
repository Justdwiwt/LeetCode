package main.java;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_984 {
    public String strWithout3a3b(int a, int b) {
        return b == 0 ? f(a, "a") : a == 0 ? f(b, "b") :
                a == b ? "ab" + strWithout3a3b(a - 1, b - 1) :
                        a > b ? "aab" + strWithout3a3b(a - 2, b - 1) : "bba" + strWithout3a3b(a - 1, b - 2);
    }

    private String f(int a, String str) {
        return IntStream.range(0, a).mapToObj(i -> str).collect(Collectors.joining());
    }
}
