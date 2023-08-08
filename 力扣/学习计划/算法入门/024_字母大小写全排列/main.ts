function letterCasePermutation(s: string): string[] {
    let res = new Array()

    const dfs = function (s: string, begin: number) {
        res.push(s)
        for (let i = begin; i < s.length; i++) {
            // 数字, 跳过此轮循环
            if (isDigit(s[i])) continue;
            // 字母, 反转字母大小写
            s = s.substr(0, i) + changeLetter(s[i]) + s.substr(i + 1)
            // 搜索
            dfs(s, i + 1)
            // 回溯, 将字母大小写反转回来
            s = s.substr(0, i) + changeLetter(s[i]) + s.substr(i + 1)
        }
    }

    dfs(s, 0)
    return res
};

/**
 * 反转字母大小写
 */
const changeLetter = function (s: String): String {
    return s >= 'a' && s <= 'z' ? s.toUpperCase() : s.toLowerCase()
}

/**
 * 判断是否是数字
 */
const isDigit = function (s: String): Boolean {
    return s >= '0' && s <= '9'
}