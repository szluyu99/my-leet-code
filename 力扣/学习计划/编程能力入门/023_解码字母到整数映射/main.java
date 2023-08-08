/**
 * https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping/comments/
 * 解码字母到整数映射
 */
class Solution {
    /**
     * 正向遍历
     */
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i + 2 < chars.length && chars[i + 2] == '#') {
                int tmp = (int) (chars[i] - '0') * 10 + (int) (chars[i + 1] - '0');
                sb.append((char) (tmp + 'a' - 1));
                i += 2;
            } else {
                sb.append((char) (chars[i] + 'a' - '1'));
            }
        }
        return sb.toString();
    }

    /**
     * 反向遍历
     */
    public String freqAlphabets1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                int tmp = s.charAt(--i) - '1' + (s.charAt(--i) - '0') * 10;
                sb.append((char) ('a' + tmp));
            } else {
                sb.append((char) ('a' + s.charAt(i) - '1'));
            }
        }
        return sb.reverse().toString();
    }
}