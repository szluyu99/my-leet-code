import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4 };
        // 数组打印 (调试时方便)
        Arrays.toString(arr); // [1, 2, 3, 4]
        // 数组排序
        Arrays.toString(arr);
        // 二分搜索 (数组必须有序)
        Arrays.binarySearch(arr, 2); // 1
        // 数组复制 (左闭右开)
        int[] newArr = Arrays.copyOfRange(arr, 0, arr.length);
        // 数组全部元素赋值
        Arrays.fill(arr, -1);
        // 比较两个数组
        Arrays.equals(arr, newArr);

        // 快速生成 List
        // List<Integer> list = Arrays.asList(1, 2, 3);

        Arrays.sort(new Integer[] {}, (n1, n2) -> n1 - n2);
    }
}
