package main.java;

public class Solution_1576 {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder('A' + s + 'A');
        for (int i = 1; i < sb.length() - 1; i++)
            if (sb.charAt(i) == '?')
                for (int j = 0; j < 26; j++) {
                    char idx = (char) (j + 'a');
                    if (idx != sb.charAt(i - 1) && idx != sb.charAt(i + 1)) {
                        sb.setCharAt(i, idx);
                        break;
                    }
                }
        return sb.substring(1, sb.length() - 1);
    }
}
