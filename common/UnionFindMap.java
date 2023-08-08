package common;

import java.util.HashMap;
import java.util.Map;

/**
 * 并查集模板: Map 实现
 */
class UnionFindMap {
    private Map<Integer, Integer> p; // 父节点
    private int size = 0; // 集合元素数量

    public UnionFindMap() {
        p = new HashMap<>();
    }

    // 将节点添加到并查集中
    public void add(int x) {
        p.put(x, x);
        size++;
    }

    // 合并两个集合
    public void merge(int x, int y) {
        int px = find(x), py = find(y);
        if (px != py) {
            p.put(find(x), find(y));
            size--;
        }
    }

    // 查找节点的祖宗节点 + 路径压缩
    public int find(int x) {
        if (p.get(x) != x) p.put(x, find(p.get(x)));
        return p.get(x);
    }

    // 判断是否 x, y 是否在一个集合中
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    // 获取集合数量
    public int getNumOfSets() {
        return size;
    }
}