package main.java;

import java.util.*;

public class Solution_726 {
    static class Node {
        public String s;
        public int count;

        public Node(String s, int count) {
            this.s = s;
            this.count = count;
        }
    }

    private final Map<String, Node> sToN = new HashMap<>();
    private int pos = 0;
    private String formula;

    public String countOfAtoms(String formula) {
        this.formula = formula;
        Queue<Node> q = new PriorityQueue<>(Comparator.comparing(node -> node.s));
        while (pos < formula.length())
            if (formula.charAt(pos) == '(') {
                Map<String, Integer> map = new HashMap<>();
                pos++;
                h(map);
                map.keySet().forEach(s -> {
                    if (!sToN.containsKey(s)) {
                        Node node = new Node(s, map.get(s));
                        q.offer(node);
                        sToN.put(s, node);
                    } else {
                        Node node = sToN.get(s);
                        node.count += map.get(s);
                    }
                });
            } else {
                StringBuilder cur = new StringBuilder();
                cur.append(formula.charAt(pos++));
                while (pos < formula.length() && formula.charAt(pos) >= 'a' && formula.charAt(pos) <= 'z')
                    cur.append(formula.charAt(pos++));
                int m = 1;
                if (pos < formula.length() && formula.charAt(pos) >= '0' && formula.charAt(pos) <= '9') m = getInt();
                if (sToN.containsKey(cur.toString())) {
                    Node node = sToN.get(cur.toString());
                    node.count += m;
                } else {
                    Node node = new Node(cur.toString(), m);
                    sToN.put(cur.toString(), node);
                    q.offer(node);
                }
            }
        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            Node node = q.poll();
            String s = node.s;
            int count = node.count;
            if (count > 1) res.append(s).append(count);
            else res.append(s);
        }
        return res.toString();
    }

    private void h(Map<String, Integer> map) {
        while (formula.charAt(pos) != ')') {
            if (formula.charAt(pos) == '(') {
                pos++;
                Map<String, Integer> m = new HashMap<>();
                h(m);
                m.keySet().forEach(s -> map.put(s, map.containsKey(s) ? Integer.valueOf(map.get(s) + m.get(s)) : m.get(s)));
            } else {
                StringBuilder cur = new StringBuilder();
                cur.append(formula.charAt(pos++));
                while (formula.charAt(pos) >= 'a' && formula.charAt(pos) <= 'z') cur.append(formula.charAt(pos++));
                int m = formula.charAt(pos) >= '0' && formula.charAt(pos) <= '9' ? getInt() : 1;
                map.put(cur.toString(), map.containsKey(cur.toString()) ? map.get(cur.toString()) + m : m);
            }
        }
        pos++;
        int m = getInt();
        if (m == 0) m = 1;
        for (String s : map.keySet()) map.put(s, map.get(s) * m);
    }

    private int getInt() {
        if (pos == formula.length()) return 1;
        int res = 0;
        while (pos < formula.length() && formula.charAt(pos) >= '0' && formula.charAt(pos) <= '9') {
            res = res * 10 + formula.charAt(pos) - '0';
            pos++;
        }
        return res;
    }
}
