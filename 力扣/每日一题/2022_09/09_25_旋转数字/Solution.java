package 每日一题.2022_09.09_25_旋转数字;

// https://leetcode.cn/problems/rotated-digits/
class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) 
            ans += isGoodNum(i);
        return ans;
    }

    // 判断是否是好数
    int isGoodNum(int n) {
        int count = 0;
        while (n > 0) {
            int t = n % 10;
            // 有 0 1 8 不一定是好数, 除非别的位遇到 2 5 6 9 才满足条件
            if (t == 2 || t == 5 || t == 6 || t == 9) count = 1;
            // 有一位是 3 4 7 就不可能是好数
            else if (t == 3 || t == 4 || t == 7) return 0; 
            n /= 10;
        }
        return count;
    }
}