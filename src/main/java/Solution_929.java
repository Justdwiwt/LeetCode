package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        Arrays.stream(emails).map(s -> s.split("@")).forEach(email -> {
            email[0] = email[0].replaceAll("\\.", "");
            email[0] = email[0].split("\\+")[0];
            set.add(email[0] + "@" + email[1]);
        });
        return set.size();
    }
}
