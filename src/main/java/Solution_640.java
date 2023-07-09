package main.java;

public class Solution_640 {
    public String solveEquation(String equation) {
        int index = -1;
        equation = equation.replace("-", "+-");
        for (int i = 0; i < equation.length(); i++)
            if (equation.charAt(i) == '=') {
                index = i;
                break;
            }
        String leftEqual = equation.substring(0, index);
        String rightEqual = equation.substring(index + 1);
        String[] left = leftEqual.split("\\+");
        String[] right = rightEqual.split("\\+");
        int[] leftNum = getNum(left);
        int[] rightNum = getNum(right);
        int x = leftNum[0] - rightNum[0];
        int num = leftNum[1] - rightNum[1];
        return x == 0 ? num == 0 ? "Infinite solutions" : "No solution" : "x=" + (-num / x);
    }

    private int[] getNum(String[] strs) {
        int xTotal = 0;
        int numTotal = 0;
        for (String str : strs)
            if (str.equals("")) {
            } else if (str.contains("x"))
                if (str.length() == 1) xTotal++;
                else if (str.length() == 2 && str.charAt(0) == '-') xTotal--;
                else {
                    String left = str.substring(0, str.length() - 1);
                    xTotal += Integer.parseInt(left);
                }
            else numTotal += Integer.parseInt(str);
        return new int[]{xTotal, numTotal};
    }
}
