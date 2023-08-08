import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * 滑动窗口
     */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while (set.contains(c))
                set.remove(s.charAt(l++));
            set.add(c);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}