package main

import "strings"

// https://leetcode.cn/problems/defanging-an-ip-address/
// 1108. IP 地址无效化
func defangIPaddr(address string) string {
	return strings.Replace(address, ".", "[.]", -1)
}
