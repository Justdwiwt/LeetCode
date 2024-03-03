package main.java;

public class Solution_150 {
    public int evalRPN(String[] tokens) {
        int idx = -1, n = tokens.length;
        int[] nums = new int[n];
        for (String s : tokens)
            switch (s) {
                case "+":
                    nums[--idx] += nums[idx + 1];
                    break;
                case "-":
                    nums[--idx] = nums[idx] - nums[idx + 1];
                    break;
                case "*":
                    nums[--idx] *= nums[idx + 1];
                    break;
                case "/":
                    nums[--idx] = nums[idx] / nums[idx + 1];
                    break;
                default:
                    nums[++idx] = Integer.parseInt(s);
                    break;
            }
        return nums[idx];
    }
}
