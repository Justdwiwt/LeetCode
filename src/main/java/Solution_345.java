package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class Solution_345 {
    public String reverseVowels(String s) {
        Stack<Character> st = new Stack<>();
        char[] arr = s.toCharArray();
        List<Integer> count = new ArrayList<>();
        IntStream.range(0, arr.length).filter(i -> arr[i] == 'a'
                || arr[i] == 'e'
                || arr[i] == 'i'
                || arr[i] == 'o'
                || arr[i] == 'u'
                || arr[i] == 'A'
                || arr[i] == 'E'
                || arr[i] == 'I'
                || arr[i] == 'O'
                || arr[i] == 'U').forEach(i -> {
            st.push(arr[i]);
            count.add(i);
        });
        StringBuilder buffer = new StringBuilder(s);
        count.forEach(x -> buffer.setCharAt(x, st.pop()));
        return buffer.toString();
    }
}
