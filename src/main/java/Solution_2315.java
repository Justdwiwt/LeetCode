package main.java;

public class Solution_2315 {
    public int countAsterisks(String s) {
        int count = 0;
        String[] str = s.split("\\|");
        for (int i = 0; i < str.length; i += 2)
            for (int j = 0; j < str[i].length(); j++)
                if (str[i].charAt(j) == '*') count++;
        return count;
    }
}
