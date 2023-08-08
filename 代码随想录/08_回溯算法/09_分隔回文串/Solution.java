import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/palindrome-partitioning/
class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, new ArrayList<>(), 0);
        return res;
    }

    void dfs(String s, List<String> path, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String ss = s.substring(start, i + 1); // 切割 
            if (isPalindrome(ss)) {
                path.add(ss);
                dfs(s, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    // 判断是否是回文串
    boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}