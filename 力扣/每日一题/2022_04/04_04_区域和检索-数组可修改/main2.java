class NumArray {
    // 树状数组
    int[] tree;

    // 模板：找到 x 的二进制数的最后一个 1 所表示的二进制
    private int lowBit(int x) {
        return x & -x;
    }

    // 模板：在树状数组 index 位置中增加值 val
    // 更新树状数组使用 x += lowBit(x) 来寻找被影响的数组下标
    private void insert(int index, int val) {
        int x = index + 1; // 下标 + 1
        while (x < tree.length) {
            tree[x] += val;
            x += lowBit(x);
        }
    }

    // 模板：查询树状数组的前缀和
    // 查询树状数组使用 x -= lowBit(x) 来寻找小于 x 的下一个区间
    private int query(int x) {
        int ans = 0;
        while (x > 0) {
            ans += tree[x];
            x -= lowBit(x);
        }
        return ans;
    }

    // 更新后的数组
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        // 原数组长度+1, +1的原因是计算lowbit时,使用下标0会进入死循环
        this.tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            // 初始化累加和数组
            insert(i, nums[i]);
        }
    }

    // 更新数组以及前缀和
    public void update(int index, int val) {
        insert(index, val - nums[index]);
        nums[index] = val;
    }

    // 区间和：求出前缀和并相减
    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }

}