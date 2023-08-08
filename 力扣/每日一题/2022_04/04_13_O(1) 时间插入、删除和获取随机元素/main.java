import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * O(1) 时间插入、删除和获取随机元素
 */
class RandomizedSet {

    Set<Integer> set;
    Random random;

    public RandomizedSet() {
        set = new HashSet<>();
        random = new Random();
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        Integer[] arr = set.toArray(new Integer[0]);
        return arr[random.nextInt(set.size())];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */