import java.util.Arrays;

// https://leetcode.cn/problems/candy/
// 贪心
class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        // 从左往右
        for (int i = 1; i < candies.length; i++)
            if (ratings[i] > ratings[i - 1]) 
                candies[i] = candies[i - 1] + 1;
        // 从右往左
        for (int i = candies.length - 2; i >= 0; i--)
            if (ratings[i] > ratings[i + 1])
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        
        int res = 0;
        for (int i = 0; i < candies.length; i++) res += candies[i];
        return res;
    }
}