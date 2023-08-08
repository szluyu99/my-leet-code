/**
 * https://leetcode-cn.com/problems/reorder-data-in-log-files/
 * 937. 重新排列日志文件
 */
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            // 将 log1 按分隔符“ ” ，分成2份，即把标识符分开来
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);

            // 判断除标识符外的第一个字符是数字true，字母false
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            // 如果两个日志都是字母日志
            if (!isDigit1 && !isDigit2) { 
                // 先比较内容字母 split1 > split2 则返回1，等于返0，小于返-1
                int cmp = split1[1].compareTo(split2[1]); 
                if (cmp != 0) return cmp;
                // 若内容字母相同则比较标识符
                return split1[0].compareTo(split2[0]);
            }
            // 不全是字母日志
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
}