package main

import (
	"bytes"
	"fmt"
	"strings"
)

// https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
// 暴力
func firstUniqChar(s string) byte {
	b := []byte(s)
	for _, v := range b {
		if bytes.LastIndexByte(b, v) == bytes.IndexByte(b, v) {
			return v
		}
	}
	return ' '
}

func firstUniqChar0(s string) byte {
	for i := 0; i < len(s); i++ {
		if strings.IndexByte(s, s[i]) == strings.LastIndexByte(s, s[i]) {
			return s[i]
		}
	}
	return ' '
}

// 迭代 + Map
func firstUniqChar2(s string) byte {
	m := make(map[byte]int, 0)

	b := []byte(s)
	for _, v := range b {
		m[v]++
	}
	for _, v := range b {
		if m[v] == 1 {
			return v
		}
	}
	return ' '
}

func firstUniqChar3(s string) byte {
	if s == "" {
		return ' '
	}
	dic := make([]int, 26)
	b := []byte(s)
	for _, v := range b {
		dic[v-'a']++
	}
	for _, v := range b {
		if dic[v-'a'] == 1 {
			return v
		}
	}
	return ' '
}

func main() {
	s := "abc"
	for i := 0; i < len(s); i++ {
		fmt.Printf("%c %v %T\n", s[i], s[i], s[i])
	}
}
