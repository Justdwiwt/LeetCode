package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_770 {
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        HashMap<String, Integer> map = IntStream.range(0, evalvars.length)
                .boxed()
                .collect(Collectors.toMap(i -> evalvars[i], i -> evalints[i], (a, b) -> b, HashMap::new));
        LinkedList<Expr> mainStack = new LinkedList<>();
        LinkedList<String> opStack = new LinkedList<>();
        int i = 0, len = expression.length();
        char[] str = expression.toCharArray();
        while (i < len) {
            if (str[i] == ' ') i++;
            else if (Character.isDigit(str[i])) {
                int x = 0;
                while (i < len && Character.isDigit(str[i])) {
                    x = 10 * x + str[i] - '0';
                    i++;
                }
                mainStack.push(new Expr(new Item(x)));
            } else if (str[i] >= 'a' && str[i] <= 'z') {
                StringBuilder sb = new StringBuilder();
                while (i < len && (str[i] >= 'a' && str[i] <= 'z')) {
                    sb.append(str[i]);
                    i++;
                }
                String s = sb.toString();
                mainStack.push(map.containsKey(s) ? new Expr(new Item(map.get(s))) : new Expr(new Item(1, s)));

            } else if (str[i] == '(') {
                opStack.push("(");
                i++;
            } else if (str[i] == ')') {
                while (!opStack.isEmpty() && !opStack.peek().equals("(")) {
                    String op = opStack.pop();
                    Expr expr2 = mainStack.pop();
                    Expr expr1 = mainStack.pop();
                    mainStack.push(expr1.operate(expr2, op));
                }
                opStack.pop();
                i++;
            } else if (str[i] == '*') {
                while (!opStack.isEmpty() && opStack.peek().equals("*")) {
                    String op = opStack.pop();
                    Expr expr2 = mainStack.pop();
                    Expr expr1 = mainStack.pop();
                    mainStack.push(expr1.operate(expr2, op));
                }
                opStack.push("*");
                i++;
            } else {
                while (!opStack.isEmpty() && (opStack.peek().equals("+") || opStack.peek().equals("-") || opStack.peek().equals("*"))) {
                    String op = opStack.pop();
                    Expr expr2 = mainStack.pop();
                    Expr expr1 = mainStack.pop();
                    mainStack.push(expr1.operate(expr2, op));
                }
                opStack.push(str[i] == '+' ? "+" : "-");
                i++;
            }
        }
        while (!opStack.isEmpty()) {
            String op = opStack.pop();
            Expr expr2 = mainStack.pop();
            Expr expr1 = mainStack.pop();
            mainStack.push(expr1.operate(expr2, op));
        }
        Expr expr = mainStack.pop();
        expr.clean();
        return expr.items.stream().map(Item::toString).collect(Collectors.toList());

    }
}


class Item implements Comparable<Item> {
    int coeff;
    ArrayList<String> factors;

    public Item(int coeff) {
        this.coeff = coeff;
        factors = new ArrayList<>();
    }

    public Item() {
        this.factors = new ArrayList<>();
        coeff = 0;
    }

    public Item(int coeff, String f) {
        this.coeff = coeff;
        this.factors = new ArrayList<>();
        factors.add(f);
    }

    @Override
    public String toString() {
        return factors.stream()
                .map(s -> "*" + s)
                .collect(Collectors.joining("", String.valueOf(coeff), ""));
    }

    @Override
    public int compareTo(Item item) {
        if (this.factors.size() == item.factors.size()) {
            int i = 0, len = this.factors.size();
            while (i < len && factors.get(i).compareTo(item.factors.get(i)) == 0) i++;
            return i == len ? 0 : factors.get(i).compareTo(item.factors.get(i));
        }
        return item.factors.size() - factors.size();
    }


    Item mutil(Item item) {
        Item res = new Item();
        res.coeff = coeff * item.coeff;
        res.factors.addAll(factors);
        res.factors.addAll(item.factors);
        res.factors.sort(String::compareTo);
        return res;
    }
}


class Expr {
    ArrayList<Item> items;

    public Expr(Item item) {
        this.items = new ArrayList<>();
        items.add(item);
    }

    void add(Expr expr) {
        items.addAll(expr.items);
        items.sort(Item::compareTo);
        clean();
    }

    void mul(Expr expr) {
        ArrayList<Item> res = new ArrayList<>();
        items.forEach(item1 -> expr.items.stream().map(item1::mutil).forEach(res::add));
        this.items = res;
        items.sort(Item::compareTo);
        clean();
    }


    void clean() {
        int i = 0;
        for (; i < items.size(); i++) {
            while (i + 1 < items.size() && items.get(i).compareTo(items.get(i + 1)) == 0) {
                items.get(i).coeff += items.get(i + 1).coeff;
                items.remove(i + 1);
            }
            if (i < items.size() && items.get(i).coeff == 0)
                items.remove(i--);
        }
    }

    Expr operate(Expr expr, String op) {
        switch (op) {
            case "*":
                mul(expr);
                break;
            case "+":
                add(expr);
                break;
            case "-":
                expr.items.forEach(item -> item.coeff *= -1);
                add(expr);
                break;
        }
        return this;
    }
}
