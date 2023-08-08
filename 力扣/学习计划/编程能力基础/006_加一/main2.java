import javax.xml.transform.Templates;

class Solution {
    /**
     * 从后往前遍历
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // 最后一位不为 9, 直接 + 1 返回结果
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            // 最后一位为 9 或 10, 需要进位
            digits[i] = 0;
        }
        // 走完 for 还没有 return, 说明数字全是 9, 直接构造出结果并返回
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}