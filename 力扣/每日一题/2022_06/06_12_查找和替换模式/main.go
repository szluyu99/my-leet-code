package main

// https://leetcode.cn/problems/find-and-replace-pattern/
// 查找和替换模式

// 双向映射
func findAndReplacePattern(words []string, pattern string) (res []string) {
	// 某个字符串是否可以映射到另一字符串
	match := func(word, pattern string) bool {
		// word 中第 i 个字符与 pattern 中第 i 个字符映射
		m := map[rune]byte{}
		// word == "mee", pattern == "abb"
		// x == 'm', y == 'a
		for i, x := range word {
			y := pattern[i]
			if m[x] == 0 {
				// 未建立映射，则建立映射
				m[x] = y
			} else if m[x] != y {
				// 已建立映射，但两者不匹配
				return false
			}
		}
		return true
	}

	for _, word := range words {
		// 满足双向映射
		if match(word, pattern) && match(pattern, word) {
			res = append(res, word)
		}
	}
	return res
}
