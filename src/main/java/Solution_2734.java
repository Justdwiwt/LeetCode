package main.java;

public class Solution_2734 {
    public String smallestString(String s) {
        char[] cs = s.toCharArray();
        int index = 0;
        while (index < cs.length && cs[index] == 'a') index++;
        if (index == cs.length) {
            cs[cs.length - 1] = 'z';
            return String.valueOf(cs);
        }
        while (index < cs.length && cs[index] != 'a') {
            cs[index] = (char) (cs[index] - 1);
            index++;
        }
        return String.valueOf(cs);
    }
}
