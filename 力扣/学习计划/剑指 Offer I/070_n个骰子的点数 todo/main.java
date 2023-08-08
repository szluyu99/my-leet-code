/**
 * n个骰子的点数
 * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
 */
class Solution {
    public double[] dicesProbability(int n) {
        double[] res = new double[n * 5 + 1];
        // 概率
        double p = Math.pow(0.16667, n);

        int idx = 0;
        // 2 * 12
        for (int i = n; i <= n * 6; i++) {
            // 找出 n 个数的所有排列组合
            int sum = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 1; k <= 6; k++) {
                    sum += k;
                    
                } 
            }
        }

    }
}