package LeetCode.LC74;

/**
 * Solution 2: treat it as 2D array.
 */
public class Solution_2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false; // empty array.
        int rows = matrix.length, cols = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[rows-1][cols-1]) return false; // corner case, target is out of the range.
        int left = 0, right = rows*cols-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            int cur = matrix[mid/cols][mid%cols]; // tricks here.
            if(cur == target) return true;
            if(cur < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
