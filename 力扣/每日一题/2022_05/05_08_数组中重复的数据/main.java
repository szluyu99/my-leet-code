import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 * 442. 数组中重复的数据
 */

class Solution {
	// 输入输出的空间不属于额外空间,
	// 使用输入数组中数字的正负来表示该位置的数字是否已经出现过
	// 遍历输入数组, 给对应位置的数字取相反数
	// - 如果是负数, 说明前面已经出现过, 放入输出数组
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int num = Math.abs(nums[i]);
			if (nums[num - 1] > 0) {
				nums[num - 1] *= -1;
			} else {
				res.add(num);
			}
		}
		return res;
	}

	// O(n) 空间
	public List<Integer> findDuplicates_1(int[] nums) {
		List<Integer> res = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		for (Map.Entry<Integer, Integer> item : map.entrySet())
			if (item.getValue() == 2)
				res.add(item.getKey());
		return res;
	}

	// O(nlogn) 时间
	public List<Integer> findDuplicates_2(int[] nums) {
		List<Integer> res = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++)
			if (nums[i] == nums[i - 1])
				res.add(nums[i]);
		return res;
	}
}
