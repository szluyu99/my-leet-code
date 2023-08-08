package CodeTop.字符串相加;

// https://leetcode.cn/problems/add-strings/
class Solution {
    public String addStrings(String num1, String num2) {
        // 确保 num1 长度更长
        if (num1.length() < num2.length()) return addStrings(num2, num1);

        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, t = 0; // 进位
        while (i >= 0 || j >= 0 || t != 0) {
            if (i >= 0) t += num1.charAt(i--) - '0';
            if (j >= 0) t += num2.charAt(j--) - '0';
            sb.append(t % 10);
            t /= 10;
        }
        return sb.reverse().toString();
    }
}