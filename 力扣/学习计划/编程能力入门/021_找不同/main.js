/**
 * @param {string} s
 * @param {string} t
 * @return {character}
 * 哈希
 */
 var findTheDifference = function (s, t) {
    let map = new Map()
    for (let c of s)
        map.set(c, map.has(c) ? map.get(c) + 1 : 1)
    for (let c of t) {
        if (!map.has(c)) return c
        if (map.get(c) > 0)
            map.set(c, map.get(c) - 1)
        else if (map.get(c) == 0)
            return c
    }
    return ''
};

