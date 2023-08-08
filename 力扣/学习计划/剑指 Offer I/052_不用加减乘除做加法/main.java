/**
 * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 */
class Solution {
    /**
     * 递归
     */
    public int add(int a, int b) {
        if (b == 0) return a;
        // 转换成 非进位和 + 进位和
        return add(a ^ b, (a & b) << 1);
    }

    /**
     * 迭代
     */
    public int add0(int a, int b) {
        while (b != 0) {
            int tempSum = a ^ b; // 计算无进位的临时结果
            int carryNum = (a & b) << 1; // 计算进位结果        
            a = tempSum;
            b = carryNum;
        }
        return a;
    }

    /**
     * 脑筋急转弯
     */
    public int add1(int a, int b) {
        return Math.addExact(a, b);
    }
    
    /**
     * 脑筋急转弯
     */
    public int add2(int a, int b) {
        return Integer.sum(a, b);
    }
}