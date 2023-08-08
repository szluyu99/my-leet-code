import java.math.BigInteger;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 * 剪绳子 II
 * 在剪绳子 I 的基础上添加了 大数运算
 */
class Solution {
    public int cuttingRope(int n) {
        BigInteger dp[] = new BigInteger[n + 1];
        Arrays.fill(dp, BigInteger.valueOf(1));
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                BigInteger tmpMax = BigInteger.valueOf(j * (i - j))
                        .max(BigInteger.valueOf(j).multiply(dp[i - j]));
                dp[i] = dp[i].max(tmpMax);
            }
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }
}