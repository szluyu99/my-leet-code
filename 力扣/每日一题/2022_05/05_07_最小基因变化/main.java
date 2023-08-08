import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 * 433. 最小基因变化
 */
class Solution {
    public int minMutation(String start, String end, String[] bank) {
		// 转化成 Set, 方便查找
		Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
		// 边界处理：如果 end 不在 bank 中, 不满足条件
		if (!bankSet.contains(end)) return -1;
		
		// 记录基因访问情况
		Set<String> used = new HashSet<>() {{ add(start); }};
		Queue<String> q = new LinkedList<>() {{ offer(start); }};

		int count = 0;
		while (!q.isEmpty()) {
			for (int i = q.size(); i > 0; i--) {
				String cur = q.poll();
				// 如果找到, 返回步数
				if (cur.equals(end)) return count;
				for (String gene : bankSet) {
					// 从 bank 中去找与当前基因只发生一个改变的基因
					if (!used.contains(gene) && isChangeOne(cur, gene)) {
						q.offer(gene);
						used.add(gene); // 标记
					}
				}
			}
			count++;
		}
		return -1;
    }

	// 判断两个基因是否只有一位不同
	boolean isChangeOne(String source, String target) {
		int changeCount = 0;
		for (int i = 0; i < 8; i++) {
			if (source.charAt(i) != target.charAt(i)) changeCount++;
			if (changeCount > 1) return false;
		}
		return changeCount == 1;
	}

	// arr => set
	static Set<String> arr2Set(String[] arr) {
		return new HashSet<>(Arrays.asList(arr));
	}

	public static void main(String[] args) {
		String[] arr = new String[] { "1", "2", "3" };
		System.out.println(arr2Set(arr).size());
	}

}
