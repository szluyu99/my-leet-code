import java.util.Arrays;
import java.util.Collections;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */
class Solution {
    /**
     * 字符串分隔
     */
    public String reverseWords(String s) {
        // 以空格分隔字符串
        String[] tmps = s.split("\\s+");
        // 反转字符串数组
        Collections.reverse(Arrays.asList(tmps));
        // 拼接反转后的字符串数组
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmps.length; i++) {
            sb.append(tmps[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * 题解：调库 
     */
    public String reverseWords1(String s) {
        // 以空格分隔字符串
        String[] tmps = s.split("\\s+");
        // 倒着拼接字符串
        StringBuffer sb = new StringBuffer();
        for (int i = s.length - 1; i > 0; i--) {
            sb.append(tmps[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}