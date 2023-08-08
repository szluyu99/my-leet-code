import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-case-permutation/
 * 字母大小写全排列
 */
class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        dfs(s.toCharArray(), 0);
        return res;
    }

    /**
     * @param cs    搜索的字符数组
     * @param start 开始搜索的位置
     */
    void dfs(char[] cs, int start) {
        res.add(String.valueOf(cs));
        for (int i = start; i < cs.length; i++) {
            // 数字, 则跳过
            if (Character.isDigit(cs[i])) continue;
            // 大小写反转
            cs[i] = reverseLetterCase(cs[i]);
            // 搜索
            dfs(cs, i + 1);
            // 回溯, 大小写反转回来
            cs[i] = reverseLetterCase(cs[i]);
        }
    }

    /**
     * 反转大小写
     * 'A' --> 'a'
     * 'a' --> 'A'
     */
    public char reverseLetterCase(char c) {
        return Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
    }
}