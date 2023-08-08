package main

import "strings"

func mergeAlternately(word1 string, word2 string) string {
	sb := strings.Builder{}
	for i := 0; i < len(word1) || i < len(word2); i++ {
		if i < len(word1) {
			sb.WriteByte(word1[i])
		}
		if i < len(word2) {
			sb.WriteByte(word2[i])
		}
	}
	return sb.String()
}
