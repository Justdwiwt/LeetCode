package main.java;

import java.util.Random;
import java.util.stream.IntStream;

public class Solution_398 {
    static class Solution {
        int[] arr;

        public Solution(int[] nums) {
            arr = nums.clone();
        }

        public int pick(int target) {
            int count = (int) IntStream.range(0, arr.length).filter(i -> arr[i] == target).count();
            int choose = new Random().nextInt(count) + 1;
            count = 0;
            for (int i = 0; i < arr.length; i++)
                if (arr[i] == target) {
                    count++;
                    if (count == choose) return i;
                }
            return -1;
        }
    }
}
