package LeetCode.LC_1_200.LC48;

/**
 * Follow up 2: rotate rectangle.
 */
public class FollowUp2 {
    private static int[][] rotate(int[][] matrix) {
        int[][] rotated = new int[matrix[0].length][matrix.length];
        int c = rotated[0].length-1;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                rotated[j][c] = matrix[i][j];
            }
            c--;
        }
        return rotated;
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
        int[][] matrix1 = {{1,2},
                           {3,4},
                           {5,6}};
        int[][] matrix2 = {{1,2,3,4},
                           {5,6,7,8},
                           {9,10,11,12}};
        print(rotate(matrix1));
        print(rotate(matrix2));
    }
}
