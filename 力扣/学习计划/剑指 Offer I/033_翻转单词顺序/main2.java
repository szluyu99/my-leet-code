class Solution {
    /**
     * 双指针
     */
    public String reverseWords(String s) {
        s = s.trim(); // 删除首尾空格
        int l = s.length() - 1, r = l;
        StringBuilder sb = new StringBuilder();
        while (l >= 0) {
            while (l >= 0 && s.charAt(l) != ' ') l--; // 搜索首个空格
            sb.append(s.subSequence(l+1, r+1) + " "); // 添加单词
            while (l >= 0 && s.charAt(l) == ' ') l--; // 跳过单词间空格
            r = l; // r 指向下个单词的尾字符
        }
        return sb.toString().trim();
    }
}