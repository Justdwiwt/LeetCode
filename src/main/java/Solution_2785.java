package main.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2785 {
    public String sortVowels(String s) {
        String temp = "AEIOUaeiou";
        List<Character> list = IntStream.range(0, s.length()).filter(i -> temp.indexOf(s.charAt(i)) != -1).mapToObj(s::charAt).sorted().collect(Collectors.toList());
        int begin = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (temp.indexOf(s.charAt(i)) != -1) sb.append(list.get(begin++));
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
