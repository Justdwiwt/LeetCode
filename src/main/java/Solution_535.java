package main.java;

import java.util.stream.IntStream;

public class Solution_535 {
    static public class Codec {

        private static final int FACTOR = 20000;

        public String encode(String longUrl) {
            char[] ch = longUrl.toCharArray();
            IntStream.range(0, ch.length).forEach(i -> ch[i] = (char) (ch[i] ^ FACTOR));
            return String.valueOf(ch);
        }

        public String decode(String shortUrl) {
            return encode(shortUrl);
        }
    }
}
