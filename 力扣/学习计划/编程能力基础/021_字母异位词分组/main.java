import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 * 字母异位词分组
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String encode = encode(s);
            if (!map.containsKey(encode)) map.put(encode, new ArrayList<>());
            map.get(encode).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // 根据出现的次数进行编码，26位
    public String encode(String s) {
        char[] code = new char[26];
        for (char c : s.toCharArray()) {
            int delta = c - 'a';
            code[delta]++;
        }
        return new String(code);
    }
}