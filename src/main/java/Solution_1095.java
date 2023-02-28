package main.java;

public class Solution_1095 {
    interface MountainArray {
        default int get(int index) {
            return 1;
        }

        default int length() {
            return 1;
        }
    }

    private int getPeek(MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length();
        int n = mountainArr.length();
        int peek = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid + 1 < n && mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                peek = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return peek + 1;
    }

    private int searchLeft(MountainArray mountainArr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = mountainArr.get(mid);
            if (value == target) return mid;
            else if (value < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    private int searchRight(MountainArray mountainArr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = mountainArr.get(mid);
            if (value == target) return mid;
            else if (value < target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peek = getPeek(mountainArr);
        int res = searchLeft(mountainArr, 0, peek - 1, target);
        return res != -1 ? res : searchRight(mountainArr, peek, mountainArr.length() - 1, target);
    }
}
