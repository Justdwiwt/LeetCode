package main.java;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_591 {
    static final String CDATA_START = "<![CDATA[";
    static final String CDATA_END = "]]>";

    String code;
    int pos;
    StringBuilder sb = new StringBuilder();
    Deque<String> tagNames;

    public boolean isValid(String code) {
        this.code = code;
        tagNames = new LinkedList<>();

        while (pos < code.length()) {
            if (readTagContent() && tagNames.isEmpty()) return false;
            if (code.startsWith("</", pos)) {
                if (!parseEndTag()) return false;
            } else if (code.startsWith(CDATA_START, pos)) {
                if (!parseCDATA()) return false;
            } else if (!parseStartTag()) return false;
        }
        return tagNames.isEmpty();
    }

    private boolean parseCDATA() {
        if (tagNames.isEmpty()) return false;
        pos += CDATA_START.length();
        while (pos < code.length() && !code.startsWith(CDATA_END, pos)) pos++;
        pos += CDATA_END.length();
        return code.startsWith(CDATA_END, pos - CDATA_END.length());
    }

    private boolean parseStartTag() {
        if (pos != 0 && tagNames.isEmpty()) return false;
        pos += 1;
        if (!readTagName()) return false;
        tagNames.push(sb.toString());
        return true;
    }

    private boolean parseEndTag() {
        pos += 2;
        if (tagNames.isEmpty() || !readTagName()) return false;
        String endTagName = sb.toString();
        return endTagName.equals(tagNames.poll());
    }

    private boolean readTagName() {
        sb.setLength(0);
        char ch;
        while (pos < code.length() && (ch = code.charAt(pos)) != '>') {
            if (ch < 'A' || ch > 'Z') return false;
            sb.append(ch);
            pos++;
        }
        pos++;
        return sb.length() >= 1 && sb.length() <= 9;
    }

    private boolean readTagContent() {
        boolean hasContent = false;
        while (pos < code.length() && code.charAt(pos) != '<') {
            pos++;
            hasContent = true;
        }
        return hasContent;
    }
}
