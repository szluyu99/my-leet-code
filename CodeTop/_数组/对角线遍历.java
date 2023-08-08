package CodeTop._数组;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/diagonal-traverse/
class Solution {
    int m;
    int n;
    int[][] mat;

    public int[] findDiagonalOrder(int[][] mat) {
        this.mat = mat;
        m = mat.length;
        n = mat[0].length;
        List<Integer> ansList = new ArrayList<>();
        boolean flipFlag = true;
        // 先遍历第一行，并用flag正反交替添加到答案列表
        for (int j = 0; j < n; j++){
            List<Integer> list = helper(0, j);
            //flag为true，反向遍历
            if (flipFlag){
                for (int k = list.size()-1; k >= 0; k--){
                    ansList.add(list.get(k));
                }
            }
            // flag为false，正向遍历
            else{
               for (int num : list){
                   ansList.add(num);
               } 
            }
            //反转flag
            flipFlag = !flipFlag;
        }
        //再遍历最后一列（注意最后一列的第一个元素在上面已经被遍历到了），并用flag正反交替添加到答案列表
        for (int i = 1; i < m; i++){
            List<Integer> list = helper(i, n-1);
            //flag为true，反向遍历
            if (flipFlag){
                for (int k = list.size()-1; k >= 0; k--){
                    ansList.add(list.get(k));
                }
            }
            //flag为false，正向遍历
            else{
               for (int num : list){
                   ansList.add(num);
               } 
            }
            //反转flag
            flipFlag = !flipFlag;
        }
        int[] ans = new int[m*n];
        for (int i = 0; i < ans.length; i++){
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    // 以(x, y)位置为起点，往左下角遍历形成list
    public List<Integer> helper(int x, int y){
        List<Integer> ans = new ArrayList<>();
        while (x >= 0 && x < m && y >= 0 && y < n){
            ans.add(mat[x][y]);
            x++;
            y--;
        }
        return ans;
    }
}