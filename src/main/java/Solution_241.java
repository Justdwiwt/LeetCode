package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_241 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        if (expression.length() < 3) {
            res.add(Integer.parseInt(expression));
            return res;
        }
        IntStream.range(1, expression.length() - 1).forEach(i -> {
            char c = expression.charAt(i);
            if (c < 48 || c > 57) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                left.forEach(a -> right.stream().map(b -> operation(a, b, c)).forEach(res::add));
            }
        });
        return res;
    }

    public int operation(int a, int b, char c) {
        return c == '+' ? a + b : c == '-' ? a - b : a * b;
    }
}
