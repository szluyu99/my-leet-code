// https://leetcode.cn/problems/minimum-window-substring/
// 滑动窗口 + 双指针
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // 当前滑动窗口中需要的各元素的数量
        // 当 need 中所有元素的数量都 <= 0 时, 表示当前滑动窗口不再需要任何元素
        // 但是每次都判断 need 中元素全部 <= 0 耗费时, 使用一个变量 count 来维护
        int[] need = new int[128]; 
        for (char c : t.toCharArray()) need[c]++;
        int count = t.length(); // 需求字符串个数, count==0 表示不需要任何元素

        // 记录最小覆盖串开始的 index 和 size
        int start = 0, size = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < s.length(); r++) {
            if (need[s.charAt(r)] > 0) count--; // 需要当前访问的字符
            need[s.charAt(r)]--; // 将当前访问的字符加入窗口

            if (count == 0) { // 窗口中包含所有字符
                // 收缩滑动窗口: 左指针走到不能走为止
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;
                    l++;
                }
                // 记录结果信息
                if (r - l + 1 < size) {
                    size = r - l + 1;
                    start = l;
                }
                need[s.charAt(l)]++;
                l++;
                count++;
            }
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}

// 滑动窗口 + 双指针
class Solution1 {
    public String minWindow(String s, String t) {
        int[] map = new int[128]; // 记录字符出现次数
        for (char c : t.toCharArray()) map[c]--; // map[c]==-1 表示需要 1 个字符 c
        int count = 0; // 总共需要的字符数, count==t.length() 则满足最小覆盖子串
        // 记录最小覆盖串开始的 index 和 size
        int start = 0, size = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < s.length(); r++) {
            if (map[s.charAt(r)] < 0) count++; // 需要当前访问的字符
            map[s.charAt(r)]++; // 访问当前字符
            // 收缩窗口: map[c] > 0 表示不需要字符 c, 可以往右移动
            while (l < r && map[s.charAt(l)] > 0) map[s.charAt(l++)]--;
            // 满足条件 并且 当前覆盖串长度更小, 则记录
            if (count == t.length() && r - l + 1 < size) {
                size = r - l + 1;
                start = l;
            }
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}