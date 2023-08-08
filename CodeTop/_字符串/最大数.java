package CodeTop._字符串;

import java.util.Arrays;

// https://leetcode.cn/problems/largest-number/
// 自定义排序规则: (s2 + s1) > (s1 + s2)
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) ss[i] = String.valueOf(nums[i]);

        // 排序 显然当 b>a 时，(b + a).compareTo(a + b) 返回 1 触发交换，因此目标是最大数
        Arrays.sort(ss, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        // 利用 "" 拼接
        String result = String.join("", ss);
        // 要注意排除 "000" 的情况
        return result.charAt(0) == '0' ? "0" : result;
    }
}