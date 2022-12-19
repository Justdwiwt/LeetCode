package main.java;

public class Solution_1432 {
    public int maxDiff(int num) {
        String str1 = String.valueOf(num);
        String str2 = String.valueOf(num);
        int a = num, b = num;
        for (int i = 0; i < str1.length(); i++)
            if (str1.charAt(i) != '9') {
                a = Integer.parseInt(str1.replace(str1.charAt(i), '9'));
                break;
            }
        for (int i = 0; i < str2.length(); i++)
            if (i == 0 && str2.charAt(i) != '1') {
                b = Integer.parseInt(str2.replace(str2.charAt(i), '1'));
                break;
            } else if (str2.charAt(i) != '1' && str2.charAt(i) != '0') {
                b = Integer.parseInt(str2.replace(str2.charAt(i), '0'));
                break;
            }
        return a - b;
    }
}
