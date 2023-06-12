package main.java;

import java.util.*;

public class Solution_736 {
    public int evaluate(String expression) {
        String[] split = expression.replace(")", " )").split(" ");
        return f(Arrays.asList(split), new HashMap<>());
    }

    private int f(List<String> items, Map<String, Integer> params) {
        boolean isLet = items.get(0).equals("(let"), isAdd = items.get(0).equals("(add");
        Stack<String> stack = new Stack<>();
        for (int i = 1; i < items.size() - 1; i++) {
            String item = items.get(i);
            if (item.startsWith("(")) {
                int j = i + 1;
                for (int cnt = 1; cnt > 0; j++)
                    if (items.get(j).startsWith("(")) ++cnt;
                    else if (items.get(j).equals(")")) --cnt;
                item = Integer.toString(f(items.subList(i, j), new HashMap<>(params)));
                i = j - 1;
            }
            if (isLet && (stack.size() & 1) != 0)
                params.put(stack.peek(), params.containsKey(item) ? params.get(item) : Integer.parseInt(item));
            stack.push(item);
        }
        String pop = stack.pop();
        int a = params.containsKey(pop) ? params.get(pop) : Integer.parseInt(pop);
        if (isLet) return a;
        pop = stack.pop();
        int b = params.containsKey(pop) ? params.get(pop) : Integer.parseInt(pop);
        return isAdd ? a + b : a * b;
    }
}
