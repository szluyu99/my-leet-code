import java.util.Map;

/**
 * https://leetcode-cn.com/problems/my-calendar-i/
 * 729. 我的日程安排表 I
 */
class MyCalendar {
    Map<Integer, Integer> map;

    public MyCalendar() {
        map = new HashMap<>();
    }

    public boolean book(int start, int end) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int min = entry.getKey(), max = entry.getValue();
            if ((start >= min && end < max) || (end >= min && end < max)) {
                return false;
            }
        }
        map.put(start, end);
        return true;
    }
}