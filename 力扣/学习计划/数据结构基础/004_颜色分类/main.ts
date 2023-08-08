/**
 * https://leetcode-cn.com/problems/sort-colors/
 * 颜色分类
 */

/**
 * 【冒泡排序】
 * ① 从头开始比较每一对相邻元素，如果第1个比第2个大，就交换它们的位置
 * 执行完一轮后，最未尾那个元素就是最大的元素
 * ② 忽略①中曾经找到的最大元素，重复执行步骤①，直到全部元素有序
 */
let sortColors = function sortColors(nums: number[]): void {
    for (let i = 0; i < nums.length; i++)
        for (let j = nums.length - 1; j > i; j--)
            if (nums[j] < nums[j - 1])
                [nums[j], nums[j - 1]] = [nums[j - 1], nums[j]]
}

/**
 * 【选择排序】
 * ① 从序列中找出最大的那个元素，然后与最未尾的元素交换位置
 * 执行完一轮后，最未尾的那个元素就是最大的元素
 * ② 忽略①中曾经找到的最大元素，重复执行步骤①
 */
sortColors = function sortColors(nums: number[]): void {
    for (let i = nums.length - 1; i > 0; i--) {
        let max = 0 // 最大元素的下标
        for (let j = 0; j <= i; j++)
            max = (nums[max] < nums[j]) ? j : max;
        [nums[max], nums[i]] = [nums[i], nums[max]]
    }
}

/**
 * 【插入排序】
 * ① 在执行过程中，插入排序会将序列分为 2 部分
 * 头部是已经排好序的，尾部是待排序的
 * ② 从头开始扫描每一个元素
 * 每当扫描到一个元素，就将它插入到头部合适的位置，使得头部数据依然保持有序
 */
sortColors = function sortColors(nums: number[]): void {
    for (let i = 0; i < nums.length; i++) {
        let cur = i;
        while (cur > 0 && nums[cur] > nums[cur - 1]) {
            [nums[cur], nums[cur - 1]] = [nums[cur - 1], nums[cur]]
            cur--
        }
    }
}

/**
 * 一次遍历
 */
sortColors = function sortColors(nums: number[]): void {
    let left = 0, right = nums.length - 1
    // left 指向第一个非 0 的数
    while (nums[left] == 0) left++;
    // right 指向从后往前第一个非 2 的数
    while (nums[right] == 2) right--;

    let i = left
    while (i <= right && left <= right) {
        if (nums[i] == 0) {
            [nums[left], nums[i]] = [nums[i], nums[left]]
            left++
            i++
        } else if (nums[i] == 2) {
            [nums[right], nums[i]] = [nums[i], nums[right]]
            right--
        } else i++
    }
}