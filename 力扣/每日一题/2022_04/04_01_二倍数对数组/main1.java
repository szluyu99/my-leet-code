import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * 模拟
     * @param arr
     * @return
     */
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : arr) map.put(n, map.getOrDefault(n, 0) + 1);
        Arrays.sort(arr);
        for (int n : arr) {
            if (map.get(n) == 0) continue;
            // 尝试寻找 2 * n
            if (n > 0 && map.containsKey(n * 2) && map.get(n * 2) != 0)
                map.put(n * 2, map.get(n * 2) - 1);
            // 奇数必须找 2 * n
            else if ((n & 1) == 0 && map.containsKey(n / 2) && map.get(n / 2) != 0)
                map.put(n / 2, map.get(n / 2) - 1);
            else return false; // 找不到直接返回
            map.put(n, map.get(n) - 1);
        }
        for (int key : map.keySet())
            if (map.get(key) != 0) return false;
        return true;
    }
}