import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * 暴力
 */
class Solution {
    public int[][] findContinuousSequence(int target) {
        int left = 1;
        List<List<Integer>> res = new ArrayList<>();
        while (left <= (target / 2)) {
            List<Integer> temp = new ArrayList<>();
            int sum = 0;
            int right = left;
            while (sum < target) {
                sum += right;  
                temp.add(right++);
                if (sum == target) 
                    res.add(temp);
            }
            left++;
        }
        // List<List<Integer>> ---> int[][]
        int [][] resArr = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            List<Integer> temp = res.get(i);
            int[] tempArr = new int[temp.size()];
            for (int j = 0; j < temp.size(); j++)
                tempArr[j] = temp.get(j);
            resArr[i] = tempArr;
        }
        return resArr;
    }
}