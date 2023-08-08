import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * 动态规划 + 哈希
     */
    public int lengthOfLongestSubstring(String s) {
        // dp[i] 代表以 s[i] 结尾的 “最长不重复子串” 的长度
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1: j - i; // dp[j - 1] - > dp[j]
            res = Math.max(res, tmp); // max(dp[j-1], dp[j])
        }
        return res;
    }
}   