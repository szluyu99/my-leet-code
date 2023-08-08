import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
// 字符串截取
class Solution {
    String[] map = new String[] {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    String digits;

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        this.digits = digits;
        dfs("", 0);
        return res;
    }

    void dfs(String path, int idx) {
        if (idx == digits.length()) {
            res.add(path);
            return;
        }
        String letters = map[digits.charAt(idx) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            dfs(path + letters.substring(i, i + 1), idx + 1);
        }
    }
}

// 标准回溯模板写法 + StringBuilder
class Solution2 {
    Map<Integer, String> map = Map.of(
            2, "abc", 3, "def", 4, "ghi", 5, "jkl",
            6, "mno", 7, "pqrs", 8, "tuv", 9, "wxyz");
    List<String> res = new ArrayList<>();
    String digits;

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        this.digits = digits;
        dfs(new StringBuilder(), 0);
        return res;
    }

    void dfs(StringBuilder path, int idx) {
        if (idx == digits.length()) {
            res.add(path.toString());
            return;
        }
        String letters = map.get(digits.charAt(idx) - '0');
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            dfs(path, idx + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}