import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * 回溯 + map 去重 + StringBuilder 优化 + 剪枝操作
 * （我的剪枝有问题吗, 怎么反而变慢了）
 */
class Solution {
    Set<String> res = new HashSet<>();

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        boolean[] visited = new boolean[chars.length];
        dfs(chars, new StringBuilder(), visited);
        return res.toArray(new String[0]);
    }

    void dfs(char[] chars, StringBuilder path, boolean[] visited) {
        if (path.length() == chars.length) {
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // 已经访问过则跳过
            if (visited[i]) continue;

            // 剪枝, 当出现重复元素跳过这次遍历
            for (int j = 0; j <= i; j++) 
                if (chars[j] == chars[i] && !visited[j]) continue;
            
            // 标记已访问过
            visited[i] = true;
            path.append(chars[i]);

            dfs(chars, path, visited); 

            // 回溯
            visited[i] = false;
            path.deleteCharAt(path.length() - 1);
        }        

    }
}