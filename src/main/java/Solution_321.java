package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        if (k > m + n) return new int[]{};
        if (m == 0) return nums2;
        if (n == 0) return nums1;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= Math.min(m, k); i++) {
            int j = k - i;
            if (j > n) continue;
            List<Integer> l1 = maxKSubsequence(nums1, i);
            List<Integer> l2 = maxKSubsequence(nums2, k - i);
            List<Integer> merge = merge(l1, l2);
            if (compare(merge, res)) res = merge;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> maxKSubsequence(int[] nums, int k) {
        LinkedList<Integer> stack = new LinkedList<>();
        int n = nums.length;
        if (k > n) k = n;
        int pop = n - k;
        for (int num : nums) {
            while (!stack.isEmpty() && num > stack.getFirst() && pop-- > 0) stack.removeFirst();
            stack.addFirst(num);
        }
        while (stack.size() > k) stack.removeFirst();
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) res.add(stack.removeLast());
        return res;
    }

    private List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        List<Integer> sub1 = l1, sub2 = l2;
        while (i < l1.size() && j < l2.size()) {
            if (compare(sub1, sub2)) {
                res.add(l1.get(i++));
                sub1 = l1.subList(i, l1.size());
            } else {
                res.add(l2.get(j++));
                sub2 = l2.subList(j, l2.size());
            }
        }
        while (i < l1.size()) res.add(l1.get(i++));
        while (j < l2.size()) res.add(l2.get(j++));
        return res;
    }

    private boolean compare(List<Integer> l1, List<Integer> l2) {
        int l = Math.min(l1.size(), l2.size());
        for (int i = 0; i < l; i++) {
            int num1 = l1.get(i);
            int num2 = l2.get(i);
            if (num1 == num2) continue;
            return num1 > num2;
        }
        return l1.size() > l2.size();
    }
}
