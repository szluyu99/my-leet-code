import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * 递归
 */
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        // 特殊情况：只有1个节点
        if (postorder.length == 1) return true;
        return verify(postorder, 0, postorder.length - 1);
    }

    /**
     * 判断后序遍历数组中的指定区间, 是不是某二叉搜索树的后序遍历结果
     * @param postorder 后序遍历数组
     * @param left 开始索引
     * @param right 结束索引
     * @return 是不是某二叉搜索树的后序遍历结果
     */
    boolean verify(int[] postorder, int left, int right) {
        // 区间不合法直接返回 true
        if (left >= right) return true;

        // 当前树的根节点(后序遍历中最后一个值)
        int rootValue = postorder[right];

        // 从当前区域找到第一个 > 根节点的，说明后续区域数值都在右子树中
        int k = left;
        while (k < right && postorder[k] < rootValue) k++;

        // 判断后续的区域是否所有值都 > 当前根节点，出现 < 的值就直接返回 false
        for (int i = k; i < right; i++)
            if (postorder[i] < rootValue) return false;

        // 检查左子树
        if (!verify(postorder, left, k - 1)) return false;
        // 检查右子树
        if (!verify(postorder, k, right - 1)) return false;

        return true;
    }
}