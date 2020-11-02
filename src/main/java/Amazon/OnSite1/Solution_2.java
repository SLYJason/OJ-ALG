package Amazon.OnSite1;

import java.util.Arrays;

public class Solution_2 {
    int maxProduct = Integer.MIN_VALUE;
    public int maxProduct(int[] A, int n, int k) {
        Arrays.sort(A);
        // Case 1: all num are positive.
        int product = 1;
        if(A[0] >= 0) {
            for(int i=n-1; i>=n-k; i--) product *= A[i];
            return product;
        }

        // Case 2: all num are negative and k is odd.
        if(A[n-1] <= 0 && k % 2 != 0) {
            for(int i=n-1; i>=n-k; i--) product *= A[i];
            return product;
        }

        // Case 3: all num are negative and k is even.
        if(A[n-1] <= 0 && k % 2 == 0) {
            for(int i=0; i<k; i++) product *= A[i];
            return product;
        }

        // Case 4: A is mix of positive and negative num, k is odd. Then the rightmost element must be included.
        int i = 0, j = n-1; // two pointers.
        if(k % 2 != 0) {
            product *= A[j];
            j--;
            k--;
        }

        // Case 5: A is mix of positive and negative num, k is even. We need to deal with pairs.
        k /= 2;
        for(int idx = 0; idx < k; idx++) {
            int left_product = A[i] * A[i+1];
            int right_product = A[j] * A[j-1];
            if(left_product < right_product) {
                product *= right_product;
                j -= 2;
            } else {
                product *= left_product;
                i += 2;
            }
        }
        return product;

    }

    public static void main(String[] args) {
        Solution_2 s = new Solution_2();
        int[] A1 = {1, 2, 0, 3};
        int n1 = 4, k1 = 2;
        System.out.println(s.maxProduct(A1, n1, k1)); // 6

        int[] A2 = {1, 2, -1, -3, -6, 4};
        int n2 = 6, k2 = 4;
        System.out.println(s.maxProduct(A2, n2, k2)); // 144

        int[] A3 = {4, 1, -7, -8, 9};
        int n3 = 5, k3 = 3;
        System.out.println(s.maxProduct(A3, n3, k3)); // 504

        int[] A4 = {1, -2, 3, 4, 5, 100, 2, 3, 1};
        int n4 = 9, k4 = 4;
        System.out.println(s.maxProduct(A4, n4, k4)); // 6000

        int[] A5 = {-10, -10, 1, 3, 2};
        int n5 = 5, k5 = 4;
        System.out.println(s.maxProduct(A5, n5, k5)); // 600

        int[] A6 = {-10, 0, -7, -6, -14};
        int n6 = 5, k6 = 3;
        System.out.println(s.maxProduct(A6, n6, k6)); // 0
    }
}
