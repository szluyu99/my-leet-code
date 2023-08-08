package main

import "fmt"

// 位运算
func toLowerCase(s string) string {
	res := ""
	for _, v := range s {
		if v >= 'A' && v <= 'Z' {
			v |= 32
		}
		res += fmt.Sprintf("%c", v)
	}
	return res
}
