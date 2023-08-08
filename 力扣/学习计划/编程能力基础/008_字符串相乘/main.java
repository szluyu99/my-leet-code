import java.math.BigInteger;

/**
 * https://leetcode-cn.com/problems/multiply-strings/
 * 字符串相乘
 */
class Solution {
    /**
     * API
     */
    public String multiply(String num1, String num2) {
        BigInteger n1 = new BigInteger(num1), n2 = new BigInteger(num2);
        return n1.multiply(n2).toString();
    }
    
    public String multiply1(String num1, String num2) {
        
        return null;
    }
}