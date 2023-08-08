import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/verifying-an-alien-dictionary/
 * 953. 验证外星语词典
 */
class Solution {
    // 重写 String 的比较函数
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++)
            if (compareTo(words[i], words[i + 1], order) > 0)
                return false;
        return true;
    }

    private int compareTo(String str, String anotherStr, String order) {
        int len1 = str.length(), len2 = anotherStr.length();
        char v1[] = str.toCharArray(), v2[] = anotherStr.toCharArray();
        int lim = Math.min(len1, len2);

        int k = 0;
        while (k < lim) {
            char c1 = v1[k], c2 = v2[k];
            if (c1 != c2)
                return order.indexOf(c1) - order.indexOf(c2);
            k++;
        }
        return len1 - len2;
    }

}
