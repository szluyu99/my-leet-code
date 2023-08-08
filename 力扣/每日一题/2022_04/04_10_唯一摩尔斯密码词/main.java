import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/unique-morse-code-words/
 * 唯一摩尔斯密码词
 */

class Solution {
    /**
     * 字符串替换 + Set 去重
     */
    public int uniqueMorseRepresentations(String[] words) {
        String[] dict = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
                "--.." };
        for (int i = 0; i < words.length; i++)
            for (char c : words[i].toCharArray())
                words[i] = words[i].replace(String.valueOf(c), dict[c - 'a']);
        return new HashSet<>(Arrays.asList(words)).size();
    }

    /**
     * StringBuilder + Set 去重
     */
    public int uniqueMorseRepresentations1(String[] words) {
        String[] dict = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
                "--.." };

        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray())
                sb.append(dict[c - 'a']);
            set.add(sb.toString());
        }
        return set.size();
    }
}