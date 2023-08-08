/**
 * https://leetcode-cn.com/problems/design-circular-queue/
 * 622. 设计循环队列
 */
class MyCircularQueue {

    int[] nums; // 元素, nums.length - 队列容量
    int head; // 当前指针
    int size; // 当前元素数量

    public MyCircularQueue(int k) {
        nums = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        nums[(head + size) % nums.length] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % nums.length;
        size--;
        return true;
    }

    public int Front() {
        return (isEmpty()) ? -1 : nums[head];
    }

    public int Rear() {
        return (isEmpty()) ? -1 : nums[(head + size - 1) % nums.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return nums.length == size;
    }
}