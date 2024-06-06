package main.java;

public class Solution_67 {
    public String addBinary(String a, String b) {
        int carry = 0;
        int cycle = Math.max(a.length(), b.length());
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < cycle; i++) {
            int aNum = 0, bNum = 0;
            if (a.length() - i - 1 >= 0) aNum = a.charAt(a.length() - i - 1) == '1' ? 1 : 0;
            if (b.length() - i - 1 >= 0) bNum = b.charAt(b.length() - i - 1) == '1' ? 1 : 0;
            binary.append((carry + aNum + bNum) % 2);
            carry = (carry + aNum + bNum) > 1 ? 1 : 0;
        }
        if (carry > 0) binary.append('1');
        return binary.reverse().toString();
    }
}
