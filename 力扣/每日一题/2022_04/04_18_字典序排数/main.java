/**
 * https://leetcode-cn.com/problems/lexicographical-numbers/
 * 字典序排数
 */

// 暴力
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        Collections.sort(list, (i1, i2) -> String.valueOf(i1).compareTo(String.valueOf(i2)));
        return list;
    }
}