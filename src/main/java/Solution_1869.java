package main.java;

public class Solution_1869 {
    public boolean checkZeroOnes(String s) {
        String[] arr1 = s.split("0");
        String[] arr0 = s.split("1");
        int one = 0;
        int zero = 0;
        for (String value : arr1) one = Math.max(one, value.length());
        for (String value : arr0) zero = Math.max(zero, value.length());
        return one > zero;
    }
}
