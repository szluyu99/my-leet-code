// https://leetcode-cn.com/problems/reverse-words-in-a-string/
// 不使用内置 API + StringBuilder
class Solution {
    public String reverseWords(String s) {
        // 1. 去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2. 反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3. 反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    // 去除首尾及中间多余空格
    StringBuilder removeSpace(String s) {
        int i = 0, j = s.length() - 1;
        while (s.charAt(i) == ' ') i++; // 去除首空格
        while (s.charAt(j) == ' ') j--; // 去除尾空格
        // 去除中间多余空格
        StringBuilder sb = new StringBuilder();
        while (i <= j) {
            char c = s.charAt(i);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ')
                sb.append(c);
            i++;
        }
        return sb;
    }

    // 翻转字符串
    void reverseString(StringBuilder sb, int i, int j) {
        while (i < j) {
            char tmp = sb.charAt(i);
            sb.setCharAt(i++, sb.charAt(j));
            sb.setCharAt(j--, tmp);
        }
    }

    // 翻转每个单词
    void reverseEachWord(StringBuilder sb) {
        int i = 0, j = 1, n = sb.length();
        while (i < n) {
            // 找到单词末尾
            while (j < n && sb.charAt(j) != ' ') j++;
            // 翻转单词
            reverseString(sb, i, j - 1);
            // 更新位置，去找下一个单词
            i = j + 1;
            j = i + 1;
        }
    }
}

// 使用 split 函数
class Solution2 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] ss = s.split("\\s+");
        for (int i = ss.length - 1; i >= 0; i--) sb.append(ss[i] + " ");
        return sb.toString().trim();
    }
}

// 从后往前遍历, 每次找到单词添加到结果
class Solution3 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int j = s.length() - 1, i = j;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            sb.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return sb.toString().trim();
    }
}