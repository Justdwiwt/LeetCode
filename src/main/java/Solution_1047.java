package main.java;

public class Solution_1047 {
    public String removeDuplicates(String S) {
        int idx = -1;
        char[] ch = S.toCharArray();
        for (int i = 0; i < ch.length; i++)
            if (idx >= 0 && ch[idx] == ch[i]) idx--;
            else {
                idx++;
                ch[idx] = ch[i];
            }
        return String.copyValueOf(ch, 0, idx + 1);
    }
}
