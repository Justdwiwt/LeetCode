package main.java;

import java.util.stream.IntStream;

public class Solution_2075 {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;

        int columns = encodedText.length() / rows;

        char[][] matrix = IntStream.range(0, rows)
                .mapToObj(i -> encodedText.substring(i * columns, (i + 1) * columns).toCharArray())
                .toArray(char[][]::new);

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < columns; i++) {
            int cnt = i;
            for (int j = 0; j < rows; j++)
                if (cnt < columns) res.append(matrix[j][cnt++]);
        }

        return res.toString().replaceAll("\\s+$", "");
    }
}
