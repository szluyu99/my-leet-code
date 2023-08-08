package main

import (
	"fmt"
	"sort"
)

type person struct {
	Name string
	Id   int
}

type personArr []person

func (x personArr) Len() int {
	return len(x)
}

func (x personArr) Less(i, j int) bool {
	return x[i].Id < x[j].Id
}

func (x personArr) Swap(i, j int) {
	x[i], x[j] = x[j], x[i]
}

func NewObj() personArr {
	return personArr{
		{"a", 3},
		{"b", 1},
		{"c", 4},
		{"d", 2},
	}
}

func main() {
	arr := NewObj()
	fmt.Println("排序前: ", arr)
	sort.Sort(arr)
	fmt.Println("排序后: ", arr)
}
