package CodeTop;

import java.util.Arrays;

// https://leetcode.cn/problems/coin-change/
class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int count = 0, sum = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            while (coins[i] + sum <= amount) {
                sum += coins[i];
                count++;
                if (sum == amount) return count;
            }
            
        } 
        return -1;
    }
}