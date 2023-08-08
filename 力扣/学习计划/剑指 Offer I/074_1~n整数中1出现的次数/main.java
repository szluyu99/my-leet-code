/**
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 * 1～n 整数中 1 出现的次数
 */
/**
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 * 1～n 整数中 1 出现的次数
 * 
 */
class Solution {
    public int countDigitOne(int n) {
        if (n < 10) return 1;
        // dp[i] i 这个整数的十进制中1出现的次数
        long[] dp = new long[n + 1];
        dp[9] = 1;
        for (int i = 10; i <= n; i++) 
            dp[i] = dp[i - 1] + getNum(i);
        return (int)dp[n];
    }
    /**
     * 获取数字 i 中 1 出现的次数
     */
    int getNum(int i) {
        int count = 0;
        for (char c : String.valueOf(i).toCharArray()) 
            if (c == '1') count++;
        return count;
    }
}

// n = 1, 1
// n = 2, 1
// n = 3, 1
// n = 4, 1
// n = 10, 1 + 1 = 2
// n = 11 = 2 + 2 +4
// n = 12, 4+1 = 5