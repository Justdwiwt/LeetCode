package main.java;

public class Solution_2232 {
    public String minimizeResult(String expression) {
        int idx = expression.indexOf("+"), n = expression.length();
        String res = "";
        int value = Integer.MAX_VALUE;
        for (int i = 0; i < idx; i++) {
            int num1 = i == 0 ? 1 : Integer.parseInt(expression.substring(0, i));
            int num2 = Integer.parseInt(expression.substring(i, idx));
            for (int j = idx + 1; j < n; j++) {
                int num3 = Integer.parseInt(expression.substring(idx + 1, j + 1));
                int num4 = j == n - 1 ? 1 : Integer.parseInt(expression.substring(j + 1, n));
                int curr = num1 * (num2 + num3) * num4;
                if (curr < value) {
                    value = curr;
                    res = "(" + num2 + "+" + num3 + ")";
                    res = i == 0 ? res : (num1 + res);
                    res = j == n - 1 ? res : (res + num4);
                }
            }
        }
        return res;
    }
}
