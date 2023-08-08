package main

import (
	"fmt"
	"strconv"
	"strings"
)

/**
 * https://leetcode-cn.com/problems/JFETK5/
 */

func addBinary(a string, b string) string {
	// 补齐较短的字符串
	// a - 10, b - 1110, 则 a 补为 0010
	if len(a) < len(b) {
		a = strings.Repeat("0", len(b)-len(a)) + a
	} else if len(b) < len(a) {
		b = strings.Repeat("0", len(a)-len(b)) + b
	}

	// 固定补0，方便后面运算
	a, b = "0"+a, "0"+b

	var flag bool // 是否进位
	var resStr string
	for i := len(a) - 1; i >= 0; i-- {
		inta, _ := strconv.Atoi(string(a[i])) // string -> int
		intb, _ := strconv.Atoi(string(b[i]))

		if inta+intb == 2 && flag { // 3
			resStr = "1" + resStr
			flag = true
		} else if inta+intb == 2 || (inta+intb == 1 && flag) { // 2
			resStr = "0" + resStr
			flag = true
		} else if inta+intb == 1 || (inta+intb == 0 && flag) { // 1
			resStr = "1" + resStr
			flag = false
		} else if inta+intb == 0 { // 0
			resStr = "0" + resStr
			flag = false
		}
	}

	// 如果前面多个0则去掉
	if strings.HasPrefix(resStr, "0") {
		resStr = resStr[1:]
	}

	return resStr
}

// 1 + 11 ==> 100
// 1 + 1 ==> 10
// 1 + 10 ==> 11
// 1 + 100 ==> 101
// 101 + 1001 ==> 1110
// 101 + 10001 ==> 10110
// 11 + 10 ==> 21 ==> 101
// 1010 + 1011 ==> 2021 ==> 10101
// 1111 + 1111 ==> 2222 ==> 11110

func main() {
	fmt.Println(addBinary("10", "0"))
}
