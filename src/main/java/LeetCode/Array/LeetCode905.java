package LeetCode.Array;

import java.util.Arrays;

public class LeetCode905 {
    /**
     * Solution 1: brute force, intuitive thought.
     */
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int even = 0, odd = A.length-1;
        for(int i=0; i<A.length; i++) {
            if(A[i] % 2 == 0) {
                res[even++] = A[i];
            } else {
                res[odd--] = A[i];
            }
        }
        return res;
    }

    /**
     * Solution 2: using Stream, concise solution.
     */
    public int[] sortArrayByParity2(int[] A) {
        return Arrays.stream(A)
                .boxed()
                .sorted((a, b) -> Integer.compare(a%2, b%2))
                .mapToInt(i -> i)
                .toArray();
    }

    /**
     * Solution 3: in-place solution.
     *
     * There are 4 cases for (A[i] % 2, A[j] % 2):
     * If it is (0, 1), then everything is correct: i++ and j--.
     * If it is (1, 0), we swap them so they are correct, then continue.
     * If it is (0, 0), only the i place is correct, so we i++ and continue.
     * If it is (1, 1), only the j place is correct, so we j-- and continue.
     */
    public int[] sortArrayByParity3(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }
        return A;
    }
}
