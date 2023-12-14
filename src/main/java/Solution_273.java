package main.java;

public class Solution_273 {
    private static final String[] set1 = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    private static final String[] set2 = {"Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    private static final String[] set3 = {"Billion ", "Million ", "Thousand ", "Hundred "};
    private static final int[] set4 = {1000000000, 1000000, 1000, 100, 20};

    public String numberToWords(int num) {
        return num == 0 ? "Zero" : helper(num).trim();
    }

    private String helper(int num) {
        if (num >= set4[0]) return helper(num / set4[0]) + set3[0] + helper(num % set4[0]);
        else if (num >= set4[1]) return helper(num / set4[1]) + set3[1] + helper(num % set4[1]);
        else if (num >= set4[2]) return helper(num / set4[2]) + set3[2] + helper(num % set4[2]);
        else if (num >= set4[3]) return helper(num / set4[3]) + set3[3] + helper(num % set4[3]);
        else if (num >= set4[4]) return set2[num / 10 - 2] + set1[num % 10];
        return set1[num];
    }
}
