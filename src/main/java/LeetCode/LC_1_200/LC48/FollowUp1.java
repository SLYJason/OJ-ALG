package LeetCode.LC_1_200.LC48;

/**
 * Follow up 1: rotate anti-clockwise.
 */
public class FollowUp1 {
    private static void rotate(int[][] matrix) {
        // transpose.
        for(int i=0; i<matrix.length; i++) {
            for(int j=i; j<matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // reverse row (top -> down)
        for(int i=0; i<matrix.length/2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[matrix.length-1-i];
            matrix[matrix.length-1-i] = tmp;
        }
    }

    private static void print(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3},
                           {4,5,6},
                           {7,8,9}};
        int[][] matrix2 = {{1,2,3,4},
                           {5,6,7,8},
                           {9,10,11,12},
                           {13,14,15,16}};
        rotate(matrix1);
        rotate(matrix2);
        print(matrix1);
        print(matrix2);
    }
}
