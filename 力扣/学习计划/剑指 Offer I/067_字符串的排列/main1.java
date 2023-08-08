import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 回溯 + list + 手动去重
 * 很慢，不如直接使用 set
 */
class Solution {
    List<String> res = new ArrayList<>();

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        boolean[] visited = new boolean[chars.length];
        dfs(chars, new String(), visited);

        // 利用 TreeSet 手动去重
        TreeSet set = new TreeSet(res); 
        res.clear();
        res.addAll(set);

        return res.toArray(new String[0]);
    }

    void dfs(char[] chars, String path, boolean[] visited) {
        if (path.length() == chars.length) {
            res.add(path);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // 已经访问过则跳过
            if (visited[i]) continue;
            
            // 标记已访问过
            visited[i] = true;
            path += chars[i];

            dfs(chars, path, visited); 

            // 回溯
            visited[i] = false;
            path = path.substring(0, path.length() - 1);
        }        

    }
}