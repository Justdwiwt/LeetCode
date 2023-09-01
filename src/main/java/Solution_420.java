package main.java;

public class Solution_420 {
    public int strongPasswordChecker(String password) {
        int res = 0;
        int small = 1, big = 1, digit = 1;
        char[] arr = password.toCharArray();
        int[] a = new int[arr.length];
        for (int i = 0; i < a.length; ) {
            if (Character.isLowerCase(arr[i])) small = 0;
            if (Character.isUpperCase(arr[i])) big = 0;
            if (Character.isDigit(arr[i])) digit = 0;
            int j = i;
            while (i < arr.length && arr[i] == arr[j]) i++;
            a[j] = i - j;
        }
        int lack = small + big + digit;
        if (a.length < 6) res += lack + Math.max(0, 6 - (a.length + lack));
        else {
            int over = Math.max(a.length - 20, 0);
            int left = 0;
            res += over;
            for (int k = 1; k < 3; k++)
                for (int i = 0; i < a.length && over > 0; i++) {
                    if (a[i] < 3 || a[i] % 3 != (k - 1))
                        continue;
                    a[i] -= Math.min(over, k);
                    over -= k;
                }
            for (int i = 0; i < a.length; i++) {
                if (a[i] >= 3 && over > 0) {
                    int need = a[i] - 2;
                    a[i] -= over;
                    over -= need;
                }
                if (a[i] >= 3) left += a[i] / 3;
            }
            res += Math.max(lack, left);
        }
        return res;
    }
}
