public class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    
        for (int j = 0; j < matrix.length / 2; j++) {
            for (int i = 0; i < matrix.length; i++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = tmp;
            }
        }
    
       for (int i = 0; i < matrix.length; i++) {
           for (int j = 0; j < matrix.length; j++) {
               System.out.print(matrix[i][j] + " ");

           }
           System.out.println();
       }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
        new Solution().rotate(matrix);
    }
}
