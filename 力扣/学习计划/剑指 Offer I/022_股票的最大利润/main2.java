class Solution {
    /**
     * 迭代
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int max = 0, res = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > max)
                max = prices[i];
            else
                res = Math.max(res, max - prices[i]);
        }
        return res;
    }
}