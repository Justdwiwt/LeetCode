package main.java;

public class Solution_38 {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String num = countAndSay(n - 1);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            int count = 1;
            while (i < num.length() - 1 && num.charAt(i) == num.charAt(i + 1)) {
                count++;
                i++;
            }
            s.append(count);
            s.append(num.charAt(i));
        }
        return s.toString();
    }
}
