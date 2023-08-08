import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    /**
     * 暴力 
     */
    public char firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                return c;
            }
        }
        return ' ';
    }

    /**
     * 哈希表
     */
    public char firstUniqChar1(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }
    
    /**
     * 有序哈希表
     */
    public char firstUniqChar2(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc)
            dic.put(c, !dic.containsKey(c));
        for (Map.Entry<Character, Boolean> d : dic.entrySet()) {
            if (d.getValue())
                return d.getKey();
        }
        return ' ';
    }
}