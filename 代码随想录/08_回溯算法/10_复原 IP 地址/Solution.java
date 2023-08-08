import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/restore-ip-addresses/
class Solution {
    List<String> res = new ArrayList<>();
    String s;

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        dfs("", 0, 0);
        return res;
    }

    void dfs(String path, int start, int cnt) {
        // 根据 IP 地址长度进行剪枝
        if (12 - cnt * 3 < s.length() - path.length()) return;
        if (cnt == 4 && path.length() >= s.length() + 4) {
            res.add(path.substring(0, path.length() - 1)); // 去除最后的 .
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String ss = s.substring(start, i + 1);
            if (ss.equals("0") || !ss.startsWith("0") && ss.length() <= 3 && Integer.parseInt(ss) <= 255) {
                path += ss + ".";
                dfs(path, i + 1, cnt + 1);
                path = path.substring(0, path.length() - ss.length() - 1);
            }
        }
    }
}