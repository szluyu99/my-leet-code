import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/fruit-into-baskets/
// map 当滑动窗口
class Solution {
    public int totalFruit(int[] fruits) {
        int res = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>(2);
        for (int l = 0, r = 0; r < fruits.length; r++) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            // 滑动窗口内水果种类 > 2 时
            while (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) map.remove(fruits[l]);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

// 数组优化哈希
class Solution1 {
    public int totalFruit(int[] fruits) {
        int[] map = new int[fruits.length];
        int res = 0, size = 0; // 当前水果种类
        for (int l = 0, r = 0; r < fruits.length; r++) {
            if (map[fruits[r]] == 0) size++;
            map[fruits[r]]++;
            // 滑动窗口内水果种类 > 2 时
            while (size > 2) {
                map[fruits[l]]--;
                if (map[fruits[l]] == 0) size--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}