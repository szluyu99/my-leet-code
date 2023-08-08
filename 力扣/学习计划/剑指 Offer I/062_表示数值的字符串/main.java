/**
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * 暴力
 */
class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() < 1 || s.startsWith("e") || s.endsWith("e") || s.startsWith("E") || s.endsWith("E"))
            return false;
        // 能否用 "e" 分隔
        String[] split = s.split("e");
        if (split.length < 1 || split.length > 2)
            return false;
        // 不能用 "e" 则尝试用 "E" 分隔
        if (split.length == 1)
            split = s.split("E");
        // 可以分隔则 分开判断
        if (split.length == 2) {
            if (split[0].length() == 0 || split[1].length() == 0)
                return false;
            return isDecimal(split[0]) && isInteger(split[1]);
        }
        // 不能分隔
        return isDecimal(s) || isInteger(s);
    }

    /**
     * 是否是 小数/整数
     */
    public boolean isDecimal(String str) {
        // 有多个 "."
        if (str.indexOf(".") != str.lastIndexOf("."))
            return false;
      	// 去除开头的 "+", "-"
        if (str.startsWith("+") || str.startsWith("-")) {
            if (str.length() == 1)
                return false;
            str = str.substring(1);
        }
      	// 能否用 "." 分隔
        String[] split = str.split("\\.");
        if (split.length == 0 || split.length > 2)
            return false;
        for (String s : split) {
            for (char c : s.toCharArray())
                if (c < '0' || c > '9')
                    return false;
        }
        return true;
    }

    /**
     * 是否是 整数
     */
    public boolean isInteger(String s) {
      	// 去除开头的 "+", "-"
        if (s.startsWith("+") || s.startsWith("-")) {
            if (s.length() == 1)
                return false;
            s = s.substring(1);
        }
        for (char c : s.toCharArray())
            if (c < '0' || c > '9')
                return false;
        return true;
    }
}