/**
 * https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 * 1356. 根据数字二进制下 1 的数目排序
 */
function sortByBits(arr: number[]): number[] {
    arr.sort((a, b) => {
        let aNum = getBinOneNum(a), bNum = getBinOneNum(b)
        return aNum == bNum ? a - b : aNum - bNum
    })
    return arr
};

/**
 * 获取 num 的二进制表示中数字 1 的个数
 */
const getBinOneNum = (num: number) => {
    let count = 0
    while (num) {
        num &= num - 1
        count++
    }
    return count
}