/**
 * https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
 * 二进制表示中质数个计算置位
 */

 /**
  * 模拟
  */
class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) 
            if (isPrime(binOneCount(i))) count++;
        return count; 
    }
    
    /**
     * 判断给定数字是否是质数
     */
    boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i <= n / 2; i++) 
            if (n % i == 0) return false;
        return true;
    }

    /**
     * 求出给定数字的二进值中 1 的个数
     */
    int binOneCount(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}