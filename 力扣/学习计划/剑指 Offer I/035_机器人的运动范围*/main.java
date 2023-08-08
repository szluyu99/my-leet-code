/**
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
class Solution {
    /**
     * 错误做法！理解错了题意，有些点无法到达。。。
     */
    public int movingCount(int m, int n, int k) {
        int res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                System.out.println(i + ", " +j + ", " + computeSum(i, j));
                if (computeSum(i, j) <= k)
                    res++;
            }
        System.out.println(res);
        return res;
    }
    /**
     * 计算 m 与 n 的数位和
     */
    int computeSum(int m, int n) {
        int sum = 0;
        while (m > 0 || n > 0) {
            sum += (m % 10 + n%10);
            m /= 10;
            n /= 10;
        }
        return sum;
    }
}