package main.java;

import java.util.stream.IntStream;

public class Solution_1618 {
    interface FontInfo {
        // Return the width of char ch when fontSize is used.
        public default int getWidth(int fontSize, char ch) {
            return 0;
        }

        // Return Height of any char when fontSize is used.
        public default int getHeight(int fontSize) {
            return 0;
        }
    }

    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int l = 0, r = fonts.length - 1;
        char[] chars = text.toCharArray();
        while (l <= r) {
            int mid = l + (r - l) / 2, W = getW(fonts[mid], fontInfo, chars), H = fontInfo.getHeight(fonts[mid]);
            if (W > w || H > h) r = mid - 1;
            else l = mid + 1;

        }
        return r >= 0 ? fonts[r] : -1;
    }

    public int getW(int frontSize, FontInfo fontInfo, char[] chars) {
        return IntStream.range(0, chars.length)
                .map(i -> fontInfo.getWidth(frontSize, chars[i]))
                .sum();
    }
}
