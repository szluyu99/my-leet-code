package CodeTop;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/restore-ip-addresses/
class Solution {
    List<String> list = new ArrayList<>();
    String s;

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        dfs("", 0, 0);
        return list;
    }

    void dfs(String path, int start, int cnt) {
        if (12 - cnt * 3 < s.length() - path.length())
            return; // 根据 IP 地址长度进行剪枝

        if (cnt == 4 && path.length() >= s.length() + 4) {
            list.add(path.substring(0, path.length() - 1)); // 去除最后的 .
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String ss = s.substring(start, i + 1);
            if (isValid(ss)) {
                dfs(path + ss + ".", i + 1, cnt + 1);
            }
        }
    }
    
    boolean isValid(String ss) {
        return ss.equals("0") || !ss.startsWith("0") && ss.length() <= 3 && Integer.parseInt(ss) <= 255;
    }
}