/**
 * https://leetcode-cn.com/problems/range-sum-query-mutable/
 * 区域和搜索 - 数组可修改
 */
class NumArray {
    int[] tree;

    // 找到 x 的二进制数的最后一个 1 所表示的二进制
    // 比如 x = 6 = 00000110
    // -x = 11111010 (x - 1 后取反)
    // lowbit(x) = x & -x = 0000010 = 2
    int lowbit(int x) {
        return x & -x;
    }

    // 查询前缀和的方法
    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i))
            ans += tree[i];
        return ans;
    }

    // 在树状数组 x 位置中增加值 u
    void add(int x, int u) {
        for (int i = x; i <= n; i += lowbit(i))
            tree[i] += u;
    }

    int[] nums;
    int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        tree = new int[n + 1];

        // 初始化树状数组 (从 1 开始)
        for (int i = 0; i < n; i++)
            add(i + 1, nums[i]);
    }

    public void update(int index, int val) {
        add(i + 1, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}