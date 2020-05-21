package LeetCode.DynamicProgramming;

public class LeetCode1277 {
    public int countSquares(int[][] matrix) {
        int res = 0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 1) {
                    if(i == 0 || j == 0) {
                        res += 1;
                    } else {
                        matrix[i][j] = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1])) + 1;
                        res += matrix[i][j];
                    }
                }
            }
        }
        return res;
    }
}
