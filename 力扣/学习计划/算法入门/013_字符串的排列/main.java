import java.util.Arrays;

/**
 * 滑动窗口 + 字典
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // 不可能的情况
        int m = s1.length(), n = s2.length();
        if (m > n) return false;

        // cnt 数组: 记录 s1 中字母出现的次数
        // cur 数组: 记录滑动的窗口中的字母出现的次数
        int[] cnt = new int[26], cur = new int[26];
        for (char c : s1.toCharArray())
            cnt[c - 'a']++;
        for (int i = 0; i < m; i++)
            cur[s2.charAt(i) - 'a']++;
        if (Arrays.equals(cnt, cur)) return true;

        for (int i = m; i < n; i++) {
            cur[s2.charAt(i) - 'a']++;
            cur[s2.charAt(i - m) - 'a']--;
            if (Arrays.equals(cnt, cur)) return true;
        }
        return false;
    }
}
