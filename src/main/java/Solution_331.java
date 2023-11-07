package main.java;

public class Solution_331 {
    public boolean isValidSerialization(String preorder) {
        if (preorder.startsWith("#") && !preorder.equals("#")) return false;
        if (!preorder.endsWith("#")) return false;
        String[] pre = preorder.split(",");
        int cnt = 1;
        for (int i = 0; i < pre.length - 1; i++) {
            cnt += pre[i].equals("#") ? -1 : 1;
            if (cnt == 0) return false;
        }
        return cnt == 1;
    }
}
