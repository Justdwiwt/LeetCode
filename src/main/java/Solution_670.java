package main.java;

public class Solution_670 {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        for (int i = 0; i < arr.length; ++i) {
            int idx = i;
            for (int j = arr.length - 1; j > i; --j)
                if (arr[idx] < arr[j]) idx = j;
            if (idx != i) {
                char temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                return Integer.parseInt(new String(arr));
            }
        }
        return num;
    }
}
