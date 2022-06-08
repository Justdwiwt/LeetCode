package main.java;

public class Solution_2296 {
    class TextEditor {
        StringBuilder sb;
        int cursor;

        public TextEditor() {
            sb = new StringBuilder();
            cursor = 0;
        }

        public void addText(String text) {
            sb.insert(cursor, text);
            cursor += text.length();
        }

        public int deleteText(int k) {
            if (cursor <= k) {
                int oldCursor = cursor;
                sb.replace(0, oldCursor, "");
                cursor = 0;
                return oldCursor;
            } else {
                sb.replace(cursor - k, cursor, "");
                cursor -= k;
                return k;
            }
        }

        public String cursorLeft(int k) {
            if (cursor >= k) {
                cursor -= k;
                return cursor >= 10 ? sb.substring(cursor - 10, cursor) : sb.substring(0, cursor);
            } else {
                cursor = 0;
                return "";
            }
        }

        public String cursorRight(int k) {
            int len = sb.length();
            if (cursor + k <= len) cursor += k;
            else cursor = len;
            return cursor >= 10 ? sb.substring(cursor - 10, cursor) : sb.substring(0, cursor);
        }
    }
}
