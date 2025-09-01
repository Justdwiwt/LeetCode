package main.java;

import java.util.Arrays;

public class Solution_2800 {
    public String minimumString(String a, String b, String c) {
        String str1 = join(join(a, b), c);
        String str2 = join(join(a, c), b);
        String str3 = join(join(b, a), c);
        String str4 = join(join(b, c), a);
        String str5 = join(join(c, a), b);
        String str6 = join(join(c, b), a);

        String res = str1;
        for (String str : Arrays.asList(str2, str3, str4, str5, str6))
            if (str.length() < res.length() || str.length() == res.length() && str.compareTo(res) < 0) res = str;
        return res;
    }

    private String join(String str1, String str2) {
        if (str1.contains(str2)) return str1;
        int minL = Math.min(str1.length(), str2.length());
        for (; minL > 0; minL--)
            if (str1.endsWith(str2.substring(0, minL))) break;
        return str1 + str2.substring(minL);
    }
}
