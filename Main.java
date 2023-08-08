import java.util.*;

/*   
14 + 9 + 28 + 12 = 63?
    |
2 3 1 8 
1 2 0 6
8 4 2 14 --
3 1 4 4

14 + 9 + 21 + 20 = 64?
2 3 1 8
1 2 0 6
4 2 1 14
6 2 8 4
*/
public class Main {
 /* Write Code Here */
    public static int calculateMaxTotalYie(int[][] cropField) {
      int m = cropField.length, n = cropField[0].length;
      int maxSum = Integer.MIN_VALUE;
      int maxI = 0, maxJ = 0;
      
      // 最大的行
      // 00 01 02 03
      // 10 11 12 13
      for (int i = 0; i < m; i++) {
        int sum = 0;
        for (int j = 0; j < n; j++) {
          sum += cropField[i][j];
        }
        if (sum > maxSum) {
          maxSum = sum;
          maxI = i;
        }
      }
      
      // 最大的列
      // 00 10 20 30
      // 01 11 21 31
      // 02 12 22 32
      maxSum = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) { // i列
        int sum = 0;
        for (int j = 0; j < m; j++) {
          sum += cropField[j][i];
        }
        if (sum > maxSum) {
          maxSum = sum;
          maxJ = i;
        }
      }

      
      int result = 0;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (i == maxI) {
            result += cropField[i][j];
          }
          if (j == maxJ) {
            result += cropField[i][j];
          }
          result += cropField[i][j];
        }
      }
      result -= cropField[maxI][maxJ];

      System.out.println(result);
      return result;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
    
        int cropField_rows = 0;
        int cropField_cols = 0;
        cropField_rows = in.nextInt();
        cropField_cols = in.nextInt();
        
        int[][] cropField = new int[cropField_rows][cropField_cols];
        for(int cropField_i=0; cropField_i<cropField_rows; cropField_i++) {
            for(int cropField_j=0; cropField_j<cropField_cols; cropField_j++) {
                cropField[cropField_i][cropField_j] = in.nextInt();
            }
        }

        if(in.hasNextLine()) {
          in.nextLine();
        }


        res = calculateMaxTotalYie(cropField);
        System.out.println(String.valueOf(res));    

    }
}
