package main.java;

public class Solution_1946 {
    public String maximumNumber(String num, int[] change) {
        for (int i = 0; i < num.length(); i++)
            if (change[num.charAt(i) - '0'] > num.charAt(i) - '0') {
                char[] res = num.toCharArray();
                for (int j = i; j < num.length() && change[num.charAt(j) - '0'] >= num.charAt(j) - '0'; j++)
                    res[j] = (char) (change[num.charAt(j) - '0'] + '0');
                return String.valueOf(res);
            }
        return num;
    }
}
