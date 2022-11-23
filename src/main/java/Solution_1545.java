package main.java;

public class Solution_1545 {
    public char findKthBit(int n, int k) {
        String str = "0";
        while (n-- > 0)
            str = str + "1" + reverse(str);
        return str.charAt(k - 1);
    }

    private String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; --i)
            sb.append(str.charAt(i) == '0' ? '1' : '0');
        return sb.toString();
    }
}
