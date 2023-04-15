package main.java;

public class Solution_925 {
    public boolean isLongPressedName(String name, String typed) {
        int cnt = 0;
        for (int j = 0; j < typed.length(); j++)
            if (cnt < name.length() && name.charAt(cnt) == typed.charAt(j)) cnt++;
            else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) return false;
        return cnt == name.length();
    }
}
