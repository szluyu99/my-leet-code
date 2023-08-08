/**
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 */
class MinStack {
    int[] vals;
    int min = Integer.MAX_VALUE;
    int index = 0;

    public MinStack() {
        vals = new int[20000];
    }
    
    public void push(int x) {
        if (x < min) {
            min = x;
        }
        vals[index++] = x;
    }
    
    public void pop() {
        int val = vals[--index];
        if (val == min) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < index; i++) {
                if (vals[i] < min) {
                    min = vals[i];
                }
            }
        }
    }
    
    public int top() {
        return vals[index - 1];
    }
    
    public int min() {
        return min;
    }

}
