package LeetCode.LC_601_800.LC658;

import java.util.List;
import java.util.ArrayList;

/**
 * Solution 1: binary search + sliding window.
 */
public class Solution_1 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = arr.length - 1;
        // step 1: use the binary search to find the closet number index left.
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                left = mid;
                break;
            } else if (arr[mid] < x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        // step 2: expand the sliding window left and right make sure the range (left, right) has k numbers.
        right = left + 1;
        while (k > 0) {
            if (left == -1) {
                right++;
                k--;
                continue;
            }
            if (right == arr.length) {
                left--;
                k--;
                continue;
            }
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left--;
            } else {
                right++;
            }
            k--;
        }
        // step 3: fill the results.
        for (int i = left + 1; i < right; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
