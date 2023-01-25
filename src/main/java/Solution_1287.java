package main.java;

public class Solution_1287 {
    public static int findSpecialInteger(int[] arr) {
        for (int i = 0, len = arr.length / 4; i < arr.length - len; i++)
            if (arr[i] == arr[i + len])
                return arr[i];
        return arr[0];
    }
}
