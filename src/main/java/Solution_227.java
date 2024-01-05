package main.java;

import java.util.Stack;

public class Solution_227 {
    public int calculate(String s) {
        int res = 0;
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= '0') num = num * 10 + ch[i] - '0';
            if ((ch[i] < '0' && ch[i] != ' ') || i == ch.length - 1) {
                if (sign == '+') stack.push(num);
                else if (sign == '-') stack.push(-num);
                else if (sign == '*' || sign == '/') {
                    int top = stack.pop();
                    stack.push(sign == '*' ? top * num : top / num);
                }
                sign = ch[i];
                num = 0;
            }
        }
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}
