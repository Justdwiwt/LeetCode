package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_1797 {
    static class AuthenticationManager {

        private final int timeToLive;

        private final Map<String, Integer> map;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
            this.map = new HashMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            this.map.put(tokenId, currentTime + this.timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            this.map.computeIfPresent(tokenId, (k, v) -> v > currentTime ? currentTime + this.timeToLive : v);
        }

        public int countUnexpiredTokens(int currentTime) {
            return (int) this.map.values().stream().filter(v -> v > currentTime).count();
        }

    }
}
