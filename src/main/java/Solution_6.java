package main.java;

public class Solution_6 {
    public String convert(String s, int numRows) {
        int rowNum = 2 * numRows - 2;
        if (numRows == 1) rowNum = 1;
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < numRows; j++)
            for (int i = 0; i < s.length(); i++)
                if (i % rowNum == j || i % rowNum == rowNum - j)
                    res.append(s.charAt(i));
        return res.toString();
    }
}
