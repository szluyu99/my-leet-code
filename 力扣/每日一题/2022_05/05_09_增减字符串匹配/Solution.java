/**
 * https://leetcode.cn/problems/di-string-match/
 * 942. 增减字符串匹配
 */
class Solution {
	public int[] diStringMatch(String s) {
		int[] res = new int[s.length() + 1];
		int min = 0, max = s.length(), idx = 0;
		for (char c : s.toCharArray())
			res[idx++] = (c == 'I') ? min++ : max--;
		res[idx] = min;
		return res;
	}
}
