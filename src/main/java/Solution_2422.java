package main.java;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class Solution_2422 {
    public int minimumOperations(int[] nums) {
        Deque<Integer> deque = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        int count = 0;
        while (deque.size() > 1) {
            if (deque.peekFirst().equals(deque.peekLast())) {
                count += 2;
                deque.removeLast();
                deque.removeFirst();
            } else if (deque.peekFirst() < deque.peekLast()) deque.addFirst(deque.removeFirst() + deque.removeFirst());
            else deque.addLast(deque.removeLast() + deque.removeLast());
        }
        return nums.length - deque.size() - count;
    }
}
