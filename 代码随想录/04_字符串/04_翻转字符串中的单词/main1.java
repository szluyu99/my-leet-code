class Solution {
    public String reverseWords(String s) {
        // 1. 去除首尾以及中间的多余空格
        StringBuilder sb = removeSpace(s);
        // 2. 反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3. 反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    // 去除字符串首尾以及中间的多余空格
    StringBuilder removeSpace(String s) {
        int start = 0, end = s.length() - 1;
        while (s.charAt(start) == ' ') start++; // 去除首空格
        while (s.charAt(end) == ' ') end--; // 去除尾空格
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            // 当前字符不为空格 或者 sb 中最后一个字符不为空格
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') sb.append(c);
            start++;
        }
        return sb;
    }

    // 反转整个字符串
    void reverseString(StringBuilder sb, int start, int end) {
        for (; start < end; start++, end--) {
            char tmp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, tmp);
        }
    }

    // 反转每个单词
    void reverseEachWord(StringBuilder sb) {
        int start = 0, end = 1, n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') end++;
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

}