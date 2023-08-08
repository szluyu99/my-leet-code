// https://leetcode.cn/problems/longest-map-prefix/
class LUPrefix {
    boolean[] map; // 已经上传
    int min = 0;

    public LUPrefix(int n) {
        map = new boolean[n + 1];
    }

    public void upload(int video) {
        map[video] = true;
        if (video == min + 1)
            while (min + 1 < map.length && map[min + 1])
                min++;
    }

    public int longest() {
        return min;
    }
}
