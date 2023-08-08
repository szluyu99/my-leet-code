// https://leetcode.cn/problems/ransom-note/
// 数组模拟哈希
class Solution {
    public boolean canConstruct(String s1, String s2) {
        int[] map = new int[123]; // s2 中字符出现的次数
        for (char c : s2.toCharArray()) map[c]++;
        for (char c : s1.toCharArray()) if (--map[c] < 0) return false;
        return true;
    }
}