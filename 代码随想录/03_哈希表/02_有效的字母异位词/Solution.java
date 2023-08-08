import java.util.Arrays;

// https://leetcode.cn/problems/valid-anagram/
// 数组模拟哈希
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] map = new int[128];
        for (char c : s.toCharArray()) map[c]++;
        for (char c : t.toCharArray())
            if (--map[c] < 0) return false;
        for (int i : map) if (i != 0) return false;
        return true;
    }
}

// 排序
class Solution1 {
    public boolean isAnagram(String s, String t) {
        char[] cs1 = s.toCharArray();
        char[] cs2 = t.toCharArray();
        Arrays.sort(cs1);
        Arrays.sort(cs2);
        return String.valueOf(cs1).equals(String.valueOf(cs2));
    }
}