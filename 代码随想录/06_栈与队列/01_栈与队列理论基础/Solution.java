import java.util.Map;
import java.util.TreeMap;

class Solution {
    public static void main(String[] args) {
        // Stack<Integer> stack = new Stack<>();
        // Queue<Integer> queue = new LinkedList<>();
        var map = Map.of(99, "a", 2, "b", 4, "d", 3, "c");
        var oMap = new TreeMap<>(map); 
        System.out.println(oMap.keySet().toString()); // [2, 3, 4, 99]
    }
}