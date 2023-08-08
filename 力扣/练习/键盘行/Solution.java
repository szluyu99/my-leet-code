package 力扣.练习.键盘行;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/keyboard-row/
class Solution {
    public String[] findWords(String[] words) {
        String[] map = new String[] { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
        List<String> list = new ArrayList<>();

        for (String word : words) { // 遍历每个单词
            int flag = -1, preFlag = -1; // 当前字符的行数 及 上个字符的行数
            for (int i = 0; i < word.length(); i++) { // 边历单词的每个字符，判断是不是同一行
                for (int j = 0; j < 3; j++) {
                    preFlag = flag; // 记录上一行
                    if (map[j].contains(String.valueOf(word.charAt(i)))) flag = j; // 更新键盘行数
                    if (flag != preFlag && preFlag != -1) break; // 不在同一行
                }
                if (flag != preFlag && preFlag != -1) break; // 不在同一行
                if (i == word.length() - 1) list.add(word); // 扫描完这个单词每个字符都在同一行, 添加到结果
            }
        }
        return list.toArray(new String[list.size()]);
    }
}

// 预处理计算出每个字符对应的行号
class Solution1 {   
    public String[] findWords(String[] words) {
        String rowIdx = "12210111011122000010020202";
        List<String> list = new ArrayList<String>();

        for (String word : words) {
            boolean valid = true;
            char idx = rowIdx.charAt(Character.toLowerCase(word.charAt(0)) - 'a'); // 行号
            for (int i = 1; i < word.length(); ++i) {
                if (rowIdx.charAt(Character.toLowerCase(word.charAt(i)) - 'a') != idx) {
                    valid = false;
                    break;
                }
            }
            if (valid) list.add(word);
        }

        return list.toArray(new String[list.size()]);
    }
}