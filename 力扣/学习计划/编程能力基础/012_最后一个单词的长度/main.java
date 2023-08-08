/**
 * https://leetcode-cn.com/problems/length-of-last-word/
 * 最后一个单词的长度
 */
class Solution {
    /**
     * 暴力
     */
    public int lengthOfLastWord(String s) {
        String[] words = s.split("\\s+");
        return words[words.length - 1].length();
    }

    /**
     * 从后往前遍历
     */
    public int lengthOfLastWord1(String s) {
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) == ' ')
                return s.length() - i - 1;
        return s.length();
    }

    /**
     * 不使用 API
     */
    public int lengthOfLastWord2(String s) {
        int i = s.length() - 1;
        // 去除末尾的 0
        while (s.charAt(i) == ' ') i--;
        int cnt = 0;
        while (i >= 0) {
            if (s.charAt(i) == ' ') return cnt;
            cnt++;
            i--;
        }
        return cnt;
    }

    /**
     * 同上
     */
    public int lengthOfLastWord3(String s) {
        int i = s.length() - 1;
        // 去除末尾的 0
        while (s.charAt(i) == ' ') i--;
        int cnt = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            cnt++;
            i--;
        }
        return cnt;
    }

}