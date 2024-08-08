package main.java;

public class Solution_12 {
    public String intToRoman(int num) {
        String[] k = new String[]{"", "M", "MM", "MMM"};
        String[] h = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] t = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] o = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return k[num / 1000] + h[(num % 1000) / 100] + t[(num % 100) / 10] + o[(num % 10)];
    }
}
