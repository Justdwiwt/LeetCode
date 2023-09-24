package main.java;

public class Solution_394 {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        char ch;
        String t;
        int rem;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') num = num * 10 + ch - '0';
            else if (ch != '[' && ch != ']') sb.append(ch);
            else if (ch == '[') {
                rem = i;
                int lalalal = 1;
                while (lalalal != 0) {
                    i++;
                    ch = s.charAt(i);
                    if (ch == '[')
                        lalalal++;
                    if (ch == ']')
                        lalalal--;
                }
                t = decodeString(s.substring(rem + 1, i));
                for (int j = 0; j < num; j++) sb.append(t);
                num = 0;
            }

        }
        return sb.toString();
    }
}
