function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
}

/**
 * @param {ListNode} head
 * @return {number}
 * 哈希
 */
var getDecimalValue = function (head) {
    let res = 0
    let map = new Map(), idx = 0
    while (head) {
        map.set(idx++, head.val)
        head = head.next
    }
    map.forEach((k, v) => res += Math.pow(2, idx - v - 1) * k)
    return res
};

/**
 * 数组
 */
var getDecimalValue = function (head) {
    let res = 0, arr = []
    while (head) {
        arr.push(head.val)
        head = head.next
    }
    arr.forEach((val, i) => res += (2 ** (arr.length - i - 1)) * val)
    return res
};

/**
 * 位运算
 */
var getDecimalValue = function (head) {
    let res = 0
    while (head) {
        res = (res << 1) + head.val
        head = head.next
    }
    return res
}