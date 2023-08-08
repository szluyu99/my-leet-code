import java.util.Arrays;

import common.TreeNode;

// https://leetcode.cn/problems/maximum-binary-tree/
// 递归
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        int maxIdx = 0;
        for (int i = 0; i < nums.length; i++) 
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIdx));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIdx + 1, nums.length));
        return root;
    }
}

// 利用索引优化数组切片操作
class Solution1 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }
    
    TreeNode help(int[] nums, int l, int r) {
        if (l > r) return null;
        int maxIdx = l;
        for (int i = l; i <= r; i++)
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = help(nums, l, maxIdx - 1);
        root.right = help(nums, maxIdx + 1, r);
        return root;
    }
}