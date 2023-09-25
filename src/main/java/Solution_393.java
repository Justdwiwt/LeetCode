package main.java;

public class Solution_393 {
    public boolean validUtf8(int[] data) {
        int cnt = 0;
        for (int datum : data)
            if (cnt == 0) {
                int mask = 128, mask2 = 64;
                if ((datum & mask) == mask && (datum & mask2) == 0)
                    return false;
                while (cnt < 8 && (datum & mask) == mask) {
                    cnt++;
                    mask >>= 1;
                }
                if (cnt > 4) return false;
                if (cnt > 0) cnt--;
            } else {
                int mask1 = 128, mask2 = 64;
                if ((datum & mask1) != mask1 || (datum & mask2) != 0)
                    return false;
                cnt--;
            }
        return cnt == 0;
    }
}
