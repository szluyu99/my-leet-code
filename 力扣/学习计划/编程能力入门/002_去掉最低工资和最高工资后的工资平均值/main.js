/**
 * @param {number[]} salary
 * @return {number}
 * 迭代
 */
var average = function (salary) {
    let sum = 0, min = salary[0], max = salary[0]

    salary.forEach(s => {
        min = Math.min(min, s)
        max = Math.max(max, s)
        sum += s
    })

    return (sum - max - min) / (salary.length - 2)
};

/**
 * @param {number[]} salary
 * @return {number}
 * reduce 
 */
var average = function (salary) {
    let sum = 0, min = salary[0], max = salary[0]

    sum = salary.reduce((pre, cur) => {
        min = Math.min(min, cur)
        max = Math.max(max, cur)
        return pre + cur
    })

    return (sum - max - min) / (salary.length - 2)
}