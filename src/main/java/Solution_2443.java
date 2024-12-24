package main.java;

public class Solution_2443 {
    public static boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            String string = new StringBuilder(String.valueOf(i)).reverse().toString();
            if ((i + Integer.parseInt(string)) == num) return true;
        }
        return false;
    }
}
