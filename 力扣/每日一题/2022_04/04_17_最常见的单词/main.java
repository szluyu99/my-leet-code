import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/most-common-word/
 * 最常见的单词
 */
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replace('!', ' ').replace('?', ' ')
                .replace('\'', ' ').replace(',', ' ')
                .replace(';', ' ').replace('.', ' ')
                .toLowerCase();

        // 禁用列表转 set, 方便后面直接判断某个单词是否被禁用
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        String[] strs = paragraph.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        String res = "";
        int maxCount = 0;
        for (String s : strs) {
            // 在禁用列表则不统计其次数
            if (bannedSet.contains(s)) continue;
            // 统计出现次数
            map.put(s, map.getOrDefault(s, 0) + 1);
            // 统计最大出线次数
            if (map.get(s) > maxCount) {
                maxCount = map.get(s);
                res = s;
            }
        }

        return res;
    }
}