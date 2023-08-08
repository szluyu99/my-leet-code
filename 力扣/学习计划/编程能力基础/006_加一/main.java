import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/plus-one/
 * 加一
 */
class Solution {
    /**
     * 分情况模拟
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        // 不会进位的情况(最后一位不为 9)
        // 例如: 123 --> 124
        if (digits[len - 1] != 9) {
            digits[len - 1] += 1;
            return digits;
        }

        // 全是9的特殊情况: 
        // 例如: 999 --> 1000
        boolean flag = true; // 是否全是9
        for (int i = 0; i < len; i++) {
            if (digits[i] != 9) {
                flag = false;
                break;
            }
        }
        if (flag) {
            int[] res = new int[len + 1];
            res[0] = 1;
            return res;
        }

        // 最后一位是9, 但是不全为 9
        // 例如: 129 --> 130
        digits[len - 1] += 1;
        while (len > 1) {
            // 无需进位, 直接跳出返回
            if (digits[len - 1] != 10) break;
            // 计算进位
            digits[len - 1] = 0;
            digits[--len - 1] += 1;
        }
        return digits;
    }
}