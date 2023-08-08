class Solution {
    /**
     * [1, 2, 3, 4, 5]
     * 左乘：[1, 1, 2, 6, 24]
     * 右乘：[120, 60, 20, 5, 1] （从右往左写的）
     * 最终结果：[120, 60, 40, 30, 24]
     */
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        for (int i = 0, product = 1; i < a.length; i++) {
            res[i] = product; // 左乘（不包含自己）
            product *= a[i];
        }
        for (int i = a.length - 1, product = 1; i >= 0; i--) {
            res[i] *= product; // 右乘（不包含自己）
            product *= a[i];
        }
        return res;
    }
}