import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 * 字母异位词分组
 */

/**
 * 排序
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String temp = getFeature(strs[i]);
            if (!map.containsKey(temp)) map.put(temp, new ArrayList<>());
            map.get(temp).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    String getFeature(String s) {
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        return String.valueOf(cs);
    }
}