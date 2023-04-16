package main.java;

public class Solution_921 {
    public int minAddToMakeValid(String S) {
        int res = 0, record = 0;
        for (int i = 0; i < S.length(); i++)
            if (S.charAt(i) == '(') record++;
            else if (record != 0) record--;
            else res++;
        return res + record;
    }
}
