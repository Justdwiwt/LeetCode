package main.java;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_2375 {
    public String smallestNumber(String pattern) {
        StringBuilder res = new StringBuilder();
        pattern += "I";
        int len = pattern.length();
        Deque<Integer> que = new LinkedList<>();
        for (int i = 1; i <= len; i++)
            if (pattern.charAt(i - 1) == 'D') que.offerLast(i);
            else {
                res.append(i);
                while (!que.isEmpty()) res.append(que.pollLast());
            }
        return res.toString();
    }
}
