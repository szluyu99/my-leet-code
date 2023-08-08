package CodeTop.LRU缓存;

import java.util.LinkedHashMap;


// https://leetcode.cn/problems/lru-cache/

// 使用 LinkedHashMap, 相当于 HashMap 存放元素是有序的
class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        // 保证每次查询后，都在末尾
        if (map.containsKey(key)) {
            int value = map.get(key);
            // make recent
            map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (capacity == map.size()) {
            // 移除第一个元素 (最久没被使用的元素)
            var iterator = map.entrySet().iterator();
			iterator.next();
            iterator.remove();
            
            // int firstKey = map.entrySet().iterator().next().getKey();
            // map.remove(firstKey);
        }
        map.put(key, value);
    }
}