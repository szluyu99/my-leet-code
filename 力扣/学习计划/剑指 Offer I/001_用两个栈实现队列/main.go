package main

import "container/list"

/*
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
type CQueue struct {
	inStack, outStack *list.List
}

func Constructor() CQueue {
	return CQueue{
		inStack:  list.New(),
		outStack: list.New(),
	}
}

func (this *CQueue) AppendTail(value int) {
	this.inStack.PushBack(value)
}

func (this *CQueue) DeleteHead() int {
	if this.outStack.Len() != 0 {
		e := this.outStack.Back()
		this.outStack.Remove(e)
		return e.Value.(int)
	}
	if this.inStack.Len() == 0 {
		return -1
	}
	for this.inStack.Len() > 0 {
		this.outStack.PushBack(this.inStack.Remove(this.inStack.Back()))
	}
	e := this.outStack.Back()
	this.outStack.Remove(e)
	return e.Value.(int)
}

/**
 * Your CQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.AppendTail(value);
 * param_2 := obj.DeleteHead();
 */
