package LeetCode.LC74;

/**
 * Solution 1: brute force, intuitive thoughts, do 2 times binary search.
 */
public class Solution_1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false; // empty array.
        int rows = matrix.length, cols = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[rows-1][cols-1]) return false; // corner case, target is out of the range.
        int left = 0, right = rows-1;
        // binary search in the first column.
        while(left <= right) {
            int mid = left + (right - left)/2;
            int cur = matrix[mid][0];
            if(cur == target) return true;
            if(cur < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int targetRow = left-1;
        left = 0;
        right = matrix[0].length-1;
        // binary search in the target row.
        while(left <= right) {
            int mid = left + (right - left)/2;
            int cur = matrix[targetRow][mid];
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
