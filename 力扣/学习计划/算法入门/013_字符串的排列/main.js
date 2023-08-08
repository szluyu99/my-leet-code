/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var checkInclusion = function (s1, s2) {
    let m = s1.length, n = s2.length
    if (m > n) return false

    let cnt1 = new Array(26).fill(0), cnt2 = new Array(26).fill(0)
    for (let c of s1)
        cnt1[c.charCodeAt() - 'a'.charCodeAt()]++
    for (let i = 0; i < m; i++)
        cnt2[s2[i].charCodeAt() - 'a'.charCodeAt()]++
    if (check(cnt1, cnt2)) return true

    for (let i = m; i < n; i++) {
        cnt2[s2[i].charCodeAt() - 'a'.charCodeAt()]++
        cnt2[s2[i - m].charCodeAt() - 'a'.charCodeAt()]--
        if (check(cnt1, cnt2)) return true
    }
    return false
}

let check = (nums1, nums2) => {
    for (let i = 0; i < nums1.length; i++)
        if (nums1[i] != nums2[i])
            return false
    return true
}