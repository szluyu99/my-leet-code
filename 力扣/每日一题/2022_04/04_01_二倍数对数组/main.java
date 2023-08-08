import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/array-of-doubled-pairs/
 * 二倍数对数组
 */
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : arr) map.put(n, map.getOrDefault(n, 0) + 1);
        Arrays.sort(arr);
        for (int n : arr) {
            if (map.get(n) == 0) continue;
            if (map.containsKey(n * 2) && map.get(n * 2) != 0) {
                map.put(n, map.get(n) - 1);
                map.put(n * 2, map.get(n * 2) - 1);
            }
        }
        for (int key : map.keySet()) 
            if (map.get(key) != 0) return false;
        return true;
    }
}
