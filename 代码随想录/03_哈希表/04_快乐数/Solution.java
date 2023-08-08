import java.util.HashSet;
import java.util.Set;

// https://leetcode.cn/problems/happy-number/
// 哈希记录, 出现重复数字表示无限循环
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            n = squareSum(n);
            if (set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }
    int squareSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }
}   