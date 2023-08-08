/**
 * 正向遍历
 */
var freqAlphabets = function (s) {
    let res = ""
    for (let i = 0; i < s.length; i++) {
        if (s[i + 2] === '#') {
            let value = +`${s[i]}${s[i + 1]}` + 96
            res += String.fromCharCode(value)
            i += 2
        } else {
            res += String.fromCharCode(+s[i] + 96)
        }
    }
    return res
}