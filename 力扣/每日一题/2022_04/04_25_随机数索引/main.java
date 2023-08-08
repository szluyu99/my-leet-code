import java.util.Random;

/**
 * https://leetcode-cn.com/problems/random-pick-index/
 * 随机数索引
 */
class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Random random = new Random();

    public Solution(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(random.nextInt(list.size()));
    }
}