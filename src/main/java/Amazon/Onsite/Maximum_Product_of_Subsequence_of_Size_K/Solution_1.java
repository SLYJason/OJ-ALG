package Amazon.Onsite.Maximum_Product_of_Subsequence_of_Size_K;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution 1: brute force, find all possible combinations.
 */
public class Solution_1 {
    int maxProduct = 1;
    public int maxProduct(int[] A, int n, int k) {
        dfs(0, A, n, k, new ArrayList<>());
        return maxProduct;
    }

    private void dfs(int start, int[] A, int n, int k, List<Integer> list) {
        if(list.size() == k) {
            int product = 1;
            for(int num : list) product *= num;
            maxProduct = Math.max(maxProduct, product);
            return;
        }
        for(int i=start; i<n; i++) {
            list.add(A[i]);
            dfs(i+1, A, n, k, list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution_1 s = new Solution_1();
        int[] A1 = {1, 2, 0, 3};
        int n1 = 4, k1 = 2;
        System.out.println(s.maxProduct(A1, n1, k1)); // 6

        s.maxProduct = Integer.MIN_VALUE;
        int[] A2 = {1, 2, -1, -3, -6, 4};
        int n2 = 6, k2 = 4;
        System.out.println(s.maxProduct(A2, n2, k2)); // 144

        s.maxProduct = Integer.MIN_VALUE;
        int[] A3 = {4, 1, -7, -8, 9};
        int n3 = 5, k3 = 3;
        System.out.println(s.maxProduct(A3, n3, k3)); // 504

        s.maxProduct = Integer.MIN_VALUE;
        int[] A4 = {1, -2, 3, 4, 5, 100, 2, 3, 1};
        int n4 = 9, k4 = 4;
        System.out.println(s.maxProduct(A4, n4, k4)); // 6000

        s.maxProduct = Integer.MIN_VALUE;
        int[] A5 = {-10, -10, 1, 3, 2};
        int n5 = 5, k5 = 4;
        System.out.println(s.maxProduct(A5, n5, k5)); // 600

        s.maxProduct = Integer.MIN_VALUE;
        int[] A6 = {-10, 0, -7, -6, -14};
        int n6 = 5, k6 = 3;
        System.out.println(s.maxProduct(A6, n6, k6)); // 0
    }
}
