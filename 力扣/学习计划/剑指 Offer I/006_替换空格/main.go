package main

import (
	"fmt"
	"strings"
)

// https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/

func replaceSpace_(s string) string {
	return strings.ReplaceAll(s, " ", "%20")
}

func main() {
	res := replaceSpace_("We are happy.")
	fmt.Printf("res: %v\n", res)
}
