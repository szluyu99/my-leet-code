import java.util.HashMap;
import java.util.Map;

/**
 * map
 */
class MyHashMap {

    public Map<Integer, Integer> map;

    public MyHashMap() {
        map = new HashMap<>();
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void remove(int key) {
        map.remove(key);
    }
}