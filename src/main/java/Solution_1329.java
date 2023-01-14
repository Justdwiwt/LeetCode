package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_1329 {
    public int[][] diagonalSort(int[][] mat) {
        for (int i = 0; i < mat.length - 1; i++) {
            List<Integer> num = new ArrayList<>();
            for (int k = 0; k < mat[0].length && i + k < mat.length; k++) num.add(mat[i + k][k]);
            Collections.sort(num);
            for (int k = 0; k < num.size(); k++) mat[i + k][k] = num.get(k);
        }
        for (int j = 1; j < mat[0].length - 1; j++) {
            List<Integer> num = new ArrayList<>();
            for (int k = 0; k < mat.length && j + k < mat[0].length; k++) num.add(mat[k][j + k]);
            Collections.sort(num);
            for (int k = 0; k < num.size(); k++) mat[k][j + k] = num.get(k);
        }
        return mat;
    }
}
