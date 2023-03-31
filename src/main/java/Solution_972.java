package main.java;

public class Solution_972 {
    public boolean isRationalEqual(String s, String t) {
        String[] n1 = s.split("\\.");
        String[] n2 = t.split("\\.");
        return Math.abs(Integer.parseInt(n1[0]) - Integer.parseInt(n2[0]) + toDivides(n1) - toDivides(n2)) < 0.00000001;
    }

    private double toDivides(String[] n) {
        if (n.length == 1) return 0;
        double b = 0;
        double c = 0;
        for (int i = 0; i < n[1].length(); i++) {
            if (n[1].charAt(i) == '(') {
                if (i > 0) b = (double) Integer.parseInt(n[1].substring(0, i)) / Math.pow(10, i);
                String s = n[1].substring(i + 1, n[1].length() - 1);
                c = (double) Integer.parseInt(s) / (Math.pow(10, i) * (Math.pow(10, s.length()) - 1));
                break;
            }
            if (i == n[1].length() - 1) b = (double) Integer.parseInt(n[1]) / Math.pow(10, n[1].length());
        }
        return b + c;
    }
}
