package common;

/**
 * 并查集模板: 数组实现
 */
public class UnionFindArr {
    private int[] p; // 父元素
    private int size = 0; // 元素数量

    public UnionFindArr(int n) {
        p = new int[n];
    }

    // 将节点添加到并查集中
    public void add(int x) {
        p[x] = x;
        size++;
    }

    // 合并两个集合
    public void merge(int x, int y) {
        int px = find(x), py = find(y);
        if (px != py) {
            p[px] = p[py];
            size--;
        }
    }

    // 查找节点的祖宗节点 + 路径压缩
    public int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
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