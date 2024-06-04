package main.java;

import java.util.Arrays;
import java.util.Stack;

public class Solution_1628 {
    static class TreeBuilder {
        Node buildTree(String[] postfix) {
            Stack<BiOpNode> stack = new Stack<>();
            Arrays.stream(postfix).forEach(s -> {
                BiOpNode node = new BiOpNode(s);
                if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                    node.right = stack.pop();
                    node.left = stack.pop();
                }
                stack.push(node);
            });
            return stack.pop();
        }

        static class BiOpNode extends Node {
            String val;
            BiOpNode left;
            BiOpNode right;

            BiOpNode(String val) {
                this.val = val;
            }

            public int evaluate() {
                switch (val) {
                    case "+":
                        return left.evaluate() + right.evaluate();
                    case "-":
                        return left.evaluate() - right.evaluate();
                    case "*":
                        return left.evaluate() * right.evaluate();
                    case "/":
                        return left.evaluate() / right.evaluate();
                    default:
                        return Integer.parseInt(val);
                }
            }
        }
    }
}
