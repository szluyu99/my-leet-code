import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/find-all-anagrams-in-a-string/submissions/
// 双指针
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[123]; 
        for (char c : p.toCharArray()) map[c]++; // map[c] < 0 表示满足需求
        int cnt = 0; // cnt == p.length() 表示满足需求
        for (int l = 0, r = 0; r < s.length(); r++) {
            if (map[s.charAt(r)]-- > 0) cnt++;
            while (l < r && map[s.charAt(l)] < 0) map[s.charAt(l++)]++;
            if (r - l + 1 == cnt && cnt == p.length()) 
                res.add(l);
        }
        return res;
    }
}