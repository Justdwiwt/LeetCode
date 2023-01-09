package main.java;

public class Solution_1346 {
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i] * 2;
            for (int j = 0; j < arr.length; j++)
                if (num == arr[j] && i != j)
                    return true;
        }
        return false;
    }
}
