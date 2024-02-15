package main.java;

public class Solution_168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 26) {
            int tmp = columnNumber % 26 == 0 ? 26 : columnNumber % 26;
            sb.insert(0, (char) ('@' + tmp));
            columnNumber -= tmp;
            columnNumber /= 26;
        }
        sb.insert(0, (char) ('@' + columnNumber));
        return sb.toString();
    }
}
