package main.java;

import java.util.Stack;

public class Solution_1106 {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch == ')') {
                int cntT = 0, cntF = 0;
                char p = st.pop();
                while (p != '(') {
                    if (p == 't') cntT++;
                    if (p == 'f') cntF++;
                    p = st.pop();
                }
                char op = st.pop();
                if (op == '!') st.add(cntT == 0 ? 't' : 'f');
                else if (op == '|') st.add(cntT == 0 ? 'f' : 't');
                else if (op == '&') st.add(cntF == 0 ? 't' : 'f');
            } else if (ch != ',') st.add(ch);
        }
        return st.pop() == 't';
    }
}
