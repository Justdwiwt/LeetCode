package main.java;

public class Solution_201 {
    public int rangeBitwiseAnd(int left, int right) {
        return right > left ? rangeBitwiseAnd(left / 2, right / 2) << 1 : left;
    }
}
