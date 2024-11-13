package main.java;

public class Solution_2399 {
    public boolean checkDistances(String s, int[] distance) {
        for (int i = 0; i < distance.length; i++) {
            int c = i + 'a';
            int index = s.indexOf(c);
            if (index != -1 && distance[i] != s.lastIndexOf(c) - index - 1) return false;
        }
        return true;
    }
}
