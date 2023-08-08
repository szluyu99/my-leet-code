/**
 * https://leetcode-cn.com/problems/richest-customer-wealth/
 * 最富有客户的资产总量
 */
class Solution {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length, n = accounts[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++)
                temp += accounts[i][j];
            max = Math.max(max, temp);
        }  
        return max;
    }
}