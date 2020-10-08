package LeetCode.LC_201_400.LC240;

/**
 * Solution: search from the bottom-left or right-top corner.
 * bottom-left: right -> increasing, up -> decreasing.
 * top-right: left -> decreasing, down -> increasing.
 *
 * Time Complexity: O(n + m).
 * Space Complexity: O(1).
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int rows = matrix.length, cols = matrix[0].length;
        int i=rows-1, j=0;
        while(i >= 0 && j < cols) {
            if(matrix[i][j] == target) return true;
            if(matrix[i][j] < target) {
                j++;
            } else{
                i--;
            }
        }
        return false;
    }
}
