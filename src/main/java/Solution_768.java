package main.java;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_768 {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int j : arr) {
            int reserve = j;
            while (!stack.isEmpty() && stack.peek() > j) reserve = Math.max(stack.pop(), reserve);
            stack.push(reserve);
        }
        return stack.size();
    }
}
