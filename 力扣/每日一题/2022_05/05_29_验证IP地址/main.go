package main

import (
	"strconv"
	"strings"
)

// https://leetcode.cn/problems/validate-ip-address/
// 468. 验证IP地址
func validIPAddress(queryIP string) string {
	if isIpv4(queryIP) {
		if validIpv4(queryIP) {
			return "IPv4"
		} else {
			return "Neither"
		}
	} else {
		if validIpv6(queryIP) {
			return "IPv6"
		} else {
			return "Neither"
		}
	}
}

func validIpv4(ip string) bool {
	ss := strings.Split(ip, ".")
	if len(ss) != 4 {
		return false
	}
	for _, s := range ss {
		if len(s) > 1 && s[0] == '0' {
			return false
		}
		i, err := strconv.Atoi(s)
		if err != nil || i > 255 {
			return false
		}
	}
	return true
}

func validIpv6(ip string) bool {
	ss := strings.Split(ip, ":")
	if len(ss) != 8 {
		return false
	}
	for _, s := range ss {
		if len(s) > 4 || s == "" {
			return false
		}
		for _, c := range s {
			if !(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F') && !(c >= '0' && c <= '9') {
				return false
			}
		}
	}
	return true
}

// 是否是 ipv4
func isIpv4(ip string) bool {
	for _, c := range ip {
		if c == '.' {
			return true
		}
		if c == ':' {
			return false
		}
	}
	return true
}
