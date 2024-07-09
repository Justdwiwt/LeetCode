package main.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_1612 {
    static class Node {
        char val;
        Node left;
        Node right;

        Node() {
            this.val = ' ';
        }

        Node(char val) {
            this.val = val;
        }

        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private void toList(Node root, List<Character> list) {
        if (null == root) return;
        if (root.val != '+') list.add(root.val);
        this.toList(root.left, list);
        this.toList(root.right, list);
    }

    public boolean checkEquivalence(Node root1, Node root2) {
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        this.toList(root1, list1);
        this.toList(root2, list2);
        list1.sort(Comparator.comparingInt((Character a) -> a));
        list2.sort(Comparator.comparingInt((Character a) -> a));
        return IntStream.range(0, list1.size()).noneMatch(i -> list1.get(i) != list2.get(i));
    }
}
