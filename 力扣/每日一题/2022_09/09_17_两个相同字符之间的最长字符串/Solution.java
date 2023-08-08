import java.util.Arrays;

// https://leetcode.cn/problems/largest-substring-between-two-equal-characters/
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        // 数组模拟哈希, 记录上个字符的最早出现位置
        int[] map = new int[128];
        Arrays.fill(map, -1); // 初始化 -1 为未出现
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c] != -1) res = Math.max(res, i - map[c] - 1); // 该字符已经出现过, 计算长度
            if (map[c] == -1) map[c] = i; // 该字符出现的最早位置
        }
        return res;
    }
}