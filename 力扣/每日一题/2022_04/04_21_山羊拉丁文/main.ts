// controller 层：主要功能是获取请求数ts传给 service 层进行处理，然后返回处理完的数据
// 不应当写过于复杂的业务逻辑
function toGoatLatin(sentence: string): string {
    return toGoatLatinService(sentence);
};

// service 层：写业务逻辑的重灾区，在这里会调用 dao 操作(本题中没有)
// 如果 service 层业务过于复杂，建议抽取一些函数规范命名让主体业务逻辑更清晰
function toGoatLatinService(sentence: string): string {
    let words = sentence.split(' ')
    for (let i = 0; i < words.length; i++) {
        words[i] = addByFirstLetter(words[i]) // 处理元音和辅音
        words[i] += 'a'.repeat(i + 1) // 根据索引添加字母 'a'
    }
    return words.join(' ')
}

// 为了让 service 层主体代码更清晰, 封装一些函数
// 这类函数可以说是纯业务需求, 没有任何通用性
// 写的再恶心也无所谓, 因为主要目的是用它的命名让 service 层主体代码更清晰
function addByFirstLetter(word: string): string {
    // 元音开头
    if (word.startsWith('a') || word.startsWith('A') || 
        word.startsWith('e') || word.startsWith('E') ||
        word.startsWith('i') || word.startsWith('I') || 
        word.startsWith('o') || word.startsWith('O') ||
        word.startsWith('u') || word.startsWith('U')) {
        word += 'ma'
    } else { // 辅音开头
        word = word.substr(1) + word.substr(0, 1) + 'ma'
    }
    return word
}