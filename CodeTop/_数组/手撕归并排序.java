package _数组;

class Solution {
    void mergeSort(int[] a, int l, int r) {
        if (l >= r) return;

        int mid = l + r >> 1;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);

        int i = l, j = mid + 1, k = 0;
        int[] tmp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            tmp[k++] = a[i] < a[j] ? a[i++] : a[j++];
        }
        while (i <= mid) tmp[k++] = a[i++];
        while (j <= r) tmp[k++] = a[j++];
        for (i = l, j = 0; i <= r; i++, j++) {
            a[i] = tmp[j];
        }
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}