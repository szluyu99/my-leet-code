import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * 380. O(1) 时间插入、删除和获取随机元素
 */
class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int index = map.get(val);
        int last = list.get(list.size() - 1); // 最后一个元素的值
        // 用最后一个元素覆盖要删除的元素(同时维护 map 和 list)
        list.set(index, last);
        map.put(last, index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIdx = random.nextInt(list.size());
        return list.get(randomIdx);
    }
}
