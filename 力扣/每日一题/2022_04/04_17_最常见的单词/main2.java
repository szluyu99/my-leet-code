import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replace('!', ' ').replace('?', ' ')
                .replace('\'', ' ').replace(',', ' ')
                .replace(';', ' ').replace('.', ' ')
                .toLowerCase();

        String[] strs = paragraph.split(" ");

        // 禁用列表转 set, 方便后面直接判断某个单词是否被禁用
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        // 使用 map 统计重复出现的单词和它出现次数
        Map<String, Integer> map = new HashMap<>();
        String res = "";
        int maxCount = 0;
        for (String s : strs) {
            // 在禁用列表则不统计其次数
            if (bannedSet.contains(s) || s.equals(""))
                continue;
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