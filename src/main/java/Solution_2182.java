package main.java;

public class Solution_2182 {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] arr = new int[26];
        for (char ch : s.toCharArray())
            arr[ch - 'a']++;

        StringBuilder res = new StringBuilder();

        for (int i = 25; i >= 0; i--)
            while (arr[i] > 0) {
                int times = Math.min(repeatLimit, arr[i]);
                arr[i] -= times;

                while (times-- > 0)
                    res.append((char) (i + 'a'));

                if (arr[i] == 0)
                    break;

                int idx = i - 1;

                while (idx >= 0 && arr[idx] == 0)
                    idx--;

                if (idx < 0)
                    return res.toString();

                res.append((char) (idx + 'a'));

                arr[idx]--;
            }
        return res.toString();
    }
}
