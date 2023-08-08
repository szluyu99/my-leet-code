import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/submissions/
 */
class MedianFinder {
    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        Collections.sort(list);
        if ((list.size() & 1) == 1) // 奇数
            return list.get(list.size() / 2);
        else { // 偶数
            int size = list.size();
            return (list.get(size / 2 - 1) + list.get(size / 2)) / 2.0;
        }
    }
}
