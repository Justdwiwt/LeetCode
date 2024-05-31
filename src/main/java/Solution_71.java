package main.java;

import java.nio.file.Paths;

public class Solution_71 {
    public String simplifyPath(String path) {
        return Paths.get(path).normalize().toString();
    }
}
