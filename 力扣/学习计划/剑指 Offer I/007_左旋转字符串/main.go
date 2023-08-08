package main

import "fmt"

// https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/

// 迭代
func reverseLeftWords(s string, n int) string {
	var pre, suffix string
	for i, v := range s {
		if i < n {
			suffix += string(v) // 前缀
		} else {
			pre += string(v) // 后缀
		}
	}
	return pre + suffix
}

// 缩小迭代范围
func reverseLeftWords2(s string, n int) string {
	res := []byte(s)
	for i := 0; i < n; i++ {
		res = append(res, s[i])
	}
	return string(res[n:])
}

// 题解：切片操作
func reverseLeftWords3(s string, n int) string {
	return s[n:] + s[:n]
}

// 反转 3 次字符串（效率依赖于反转字符串的效率）
func reverseLeftWords4(s string, n int) string {
	s1 := reverse(s[:n])
	s2 := reverse(s[n:])
	return reverse(s1 + s2)
}

func reverse(str string) string {
	if len(str) == 1 {
		return str
	}
	if len(str) == 2 {
		return str[1:] + str[:1]
	}
	return str[len(str)-1:] + reverse(str[:len(str)-1])
}

func main() {
	s := "abcdefg"
	fmt.Println(reverseLeftWords(s, 2))
}
