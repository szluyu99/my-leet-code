package CodeTop.LRU缓存;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {
    Map<Integer, Integer> map = new HashMap<>();
    Deque<Integer> list = new LinkedList<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove(key);
            list.addLast(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            list.remove(key);
        }

        if (map.size() == capacity) {
            int lastKey = list.pollFirst();
            map.remove(lastKey);
        }

        map.put(key, value);
        list.addLast(key);
    }
}
