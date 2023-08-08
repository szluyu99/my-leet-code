import java.util.Arrays;
import java.util.Collections;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 颠倒字符串中的单词
 */
class Solution {
    // 利用 "\\s+" 正则分隔
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        
        String[] ss = s.split("\\s+");
        for (int i = ss.length - 1; i >= 0; i--) sb.append(ss[i] + " ");

        return sb.toString().trim();
    }

    // 利用 " " 正则分隔
    public String reverseWords1(String s) {
        StringBuilder sb = new StringBuilder();
        
        String[] ss = s.split(" ");
        for (int i = ss.length - 1; i >= 0; i--) {
            if (ss[i] == "") continue;
            sb.append(ss[i] + " ");
        }

        return sb.toString().trim();
    }
    
    // 工具类
    public String reverseWords2(String s) {
        String[] ss = s.trim.split(" +");
        Collections.reverse(Arrays.asList(ss));
        return String.join(" ", ss);
    }
}