// 字符串写法
let letterCombinations = (digits: string): string[] => {
    const map = new Map([
        [2, 'abc'], [3, 'def'], [4, 'ghi'], [5, 'jkl'],
        [6, 'mno'], [7, 'pqrs'], [8, 'tuv'], [9, 'wxyz'],
    ]);
    if (!digits.length) return [];
    let res = [];
    const dfs = (path: string, idx: number) => {
        if (idx === digits.length) {
            res.push(path);
            return;
        }
        let letters = map.get(Number(digits[idx]));
        for (let i = 0; i < letters.length; i++) {
            dfs(path + letters.substring(i, i + 1), idx + 1);
        }
    }
    dfs("", 0);
    return res;
};

// 标准的回溯模板
letterCombinations = (digits: string): string[] => {
    const map = new Map([
        [2, 'abc'], [3, 'def'], [4, 'ghi'], [5, 'jkl'],
        [6, 'mno'], [7, 'pqrs'], [8, 'tuv'], [9, 'wxyz'],
    ]);
    if (!digits.length) return [];

    let res = [];
    const dfs = (path: string, idx: number) => {
        if (idx === digits.length) {
            res.push(path);
            return;
        }
        let letters = map.get(Number(digits.charAt(idx)));
        for (let i = 0; i < letters.length; i++) {
            path += letters[i];
            dfs(path, idx + 1);
            path = path.substring(0, path.length - 1);
        }
    }

    dfs("", 0);
    return res;
};