// https://leetcode.cn/problems/repeated-substring-pattern/
// 暴力 + 剪枝
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 1; i <= (len >> 1); i++) {
            // 字符串的长度不是串的整数倍, 必然不满足条件
            if (len % i != 0) continue;
            String sub = s.substring(0, i); // 枚举子串
            // 字符串不以该子串结尾, 必然不满足条件
            if (!sub.equals(s.substring(len - i))) continue; 
            if (sub.repeat(len / i).equals(s)) return true;
        }    
        return false;
    }
}

// 去头去尾
class Solution1 {
    public boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        return ss.substring(1, ss.length() - 1).contains(s);
    }
}