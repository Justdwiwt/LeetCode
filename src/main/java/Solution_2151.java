package main.java;

public class Solution_2151 {
    public int maximumGood(int[][] statements) {
        int[] arr1 = new int[statements.length];
        int[] arr2 = new int[statements.length];
        for (int i = 0; i < statements.length; i++)
            for (int j = 0; j < statements.length; j++)
                if (statements[i][j] == 0)
                    arr2[i] |= (1 << j);
                else if (statements[i][j] == 1)
                    arr1[i] |= (1 << j);
        int res = 0;
        for (int i = 0; i < (1 << statements.length); i++) {
            boolean flag = true;
            for (int j = 0; j < statements.length; j++)
                if ((i & (1 << j)) != 0 && ((i & (arr2[j])) != 0 || ((((1 << statements.length) - 1) ^ i) & arr1[j]) != 0)) {
                    flag = false;
                    break;
                }
            if (flag)
                res = Math.max(res, Integer.bitCount(i));
        }
        return res;
    }
}
