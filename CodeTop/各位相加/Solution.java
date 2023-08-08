package CodeTop.各位相加;

// https://leetcode.cn/problems/add-digits/comments/
// 模拟
class Solution {
    public int addDigits(int num) {
        int res = -1;
        while (res >= 10 || res == -1) {
            res = allSum(num);
            num = res;
        }
        return res;
    }

    // 计算数字各位和
    int allSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}

// 优雅代码
class Solution1 {
    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}