// https://leetcode.cn/problems/reformat-phone-number/
// 模拟
class Solution {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        // 处理: 删除字符串中的 ' ' 和 '-'
        for (char c : number.toCharArray())
            if (Character.isDigit(c)) sb.append(c);
        
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sb.length(); ) {
            if (i + 4 < sb.length()) { // 剩余数字 > 4
                res.append(sb.substring(i, i + 3));
                i += 3;
            } else { // 剩余数字 <= 4
                int len = sb.length() - i;
                if (len <= 3) res.append(sb.substring(i, i + len));
                else {
                    res.append(sb.substring(i, i + 2));
                    res.append('-');
                    res.append(sb.substring(i + 2, i + 4));
                }
                i += len;
            }
            res.append('-');
        }
        res.deleteCharAt(res.length() - 1); // 删除最后多余的 '-'
        return res.toString();
    }
}

class Solution1 {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        int idx = 0; // 记录数字的个数
        char[] cs = number.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (!Character.isDigit(cs[i])) continue;
            idx++;
            sb.append(cs[i]);
            // 每三个数组加一个 '-'
            if (idx > 0 && idx % 3 == 0) sb.append('-');
        }
        // 处理最后一次: 
        // 3 个数字: "123-456-" => "123-456"
        if (idx % 3 == 0) sb.deleteCharAt(sb.length() - 1);
        // 4 个数字: "123-456-7" => "123-45-67"
        else if (idx % 4 == 0) 
            sb.deleteCharAt(sb.length() - 2).insert(sb.length() - 2, '-');
        return sb.toString();
    }
}