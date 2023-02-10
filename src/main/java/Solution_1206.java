package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_1206 {
    static class Skiplist {
        List<Integer> nums = null;

        public Skiplist() {
            nums = new ArrayList<>();
        }

        public boolean search(int target) {
            if (nums.size() == 0) return false;
            int left = 0;
            int right = nums.size() - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                int midNum = nums.get(mid);
                if (left == right) return midNum == target;
                if (target == midNum) return true;
                else if (target > midNum) left = ++mid;
                else right = mid;
            }
            return false;
        }

        public void add(int num) {
            if (nums.size() == 0) {
                nums.add(num);
                return;
            }
            int left = 0;
            int right = nums.size() - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                int midNum = nums.get(mid);
                if (left == right) {
                    if (midNum < num) nums.add(++mid, num);
                    else nums.add(mid, num);
                    break;
                }
                if (num == midNum) {
                    nums.add(mid, num);
                    break;
                } else if (num > midNum) left = ++mid;
                else right = mid;
            }
        }

        public boolean erase(int num) {
            if (nums.size() == 0) return false;
            int left = 0;
            int right = nums.size() - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                int midNum = nums.get(mid);
                if (left == right)
                    if (midNum == num) {
                        nums.remove(mid);
                        return true;
                    } else return false;
                if (num == midNum) {
                    nums.remove(mid);
                    return true;
                } else if (num > midNum) left = ++mid;
                else right = mid;
            }
            return false;
        }
    }
}
