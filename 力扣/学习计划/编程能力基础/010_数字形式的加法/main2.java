import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


class Solution {
    /**
     * 模拟：往后插入数据，最后反转容器
    */
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int carry = 0, len = num.length - 1;
        while (len >= 0 || k != 0) {
            int n1 = len >= 0 ? num[len--] : 0;
            int n2 = k % 10;
            k /= 10;
            res.add((n1 + n2 + carry) % 10);
            carry = n1 + n2 + carry >= 10 ? 1 : 0;
        }
        if (carry == 1) res.add(1);
        Collections.reverse(res);
        return res;
    }
    /**
     * 模拟：改用 LinkedList 往前插
     */
    public List<Integer> addToArrayForm1(int[] num, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        int carry = 0, len = num.length - 1;
        while (len >= 0 || k != 0) {
            int n1 = len >= 0 ? num[len--] : 0;
            int n2 = k % 10;
            k /= 10;
            res.addFirst((n1 + n2 + carry) % 10);
            carry = n1 + n2 + carry >= 10 ? 1 : 0;
        }
        if (carry == 1) res.addFirst(1);
        return res;
    }
}