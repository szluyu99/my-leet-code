import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * 使用 LinkedList 会超时, ArrayList 可以通过(耗时高)
 */
class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i);
        int cur = 0;
        while (list.size() > 1) {
            cur += m - 1;
            if (cur >= list.size())
                cur = cur % list.size();
            list.remove(cur);
        }
        return list.get(0);
    }
}