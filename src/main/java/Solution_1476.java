package main.java;

public class Solution_1476 {
    static class SubrectangleQueries {

        private int[][] rect = null;

        public SubrectangleQueries(int[][] rectangle) {
            this.rect = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            if (rect != null)
                for (; row1 <= row2; row1++)
                    for (int i = col1; i <= col2; i++)
                        rect[row1][i] = newValue;
        }

        public int getValue(int row, int col) {
            if (rect != null) return rect[row][col];
            return -1;
        }
    }
}
