package CodeTop._字符串;

// https://leetcode.cn/problems/decode-string/
class Solution {
    public String decodeString(String s) {
        if (!s.contains("[")) return s;

        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        int count = 0; // [ 的数量
        int l = 0, r = 0; // [] 的位置
        int repeat = 0; // 重复次数
        for (int i = 0; i < cs.length; i++) {
            if (count == 0 && cs[i] >= 'a' && cs[i] <= 'z')
                sb.append(cs[i]);
            else if (count == 0 && cs[i] >= '0' && cs[i] <= '9')
                repeat = repeat * 10 + (cs[i] - '0');
            else if (cs[i] == '[') {
                if (count == 0) l = i;
                count++;
            } else if (cs[i] == ']') {
                count--;
                if (count == 0) {
                    r = i;
                    while (repeat > 0) {
                        sb.append(s.substring(l + 1, r));
                        repeat--;
                    }
                }
            }
        }
        return decodeString(sb.toString());
    }
}