package LeetCode.LC_2001_2200.LC2055;

/**
 * Solution: prefix sum.
 */
public class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] prefixSum = new int[n];
        int[] res = new int[queries.length];

        // step 1: calculate the prefixSum, prefixSum[i] means how many candles previously before and at index i.
        for (int i = 0, plates = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                plates++;
            }
            prefixSum[i] = plates;
        }

        // step 2: calculate the left[], left[i] means the current index i the first left candle position.
        int[] left = new int[n];
        for (int i = 0, l = -1; i < n; i++) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }

        // step 3: calculate the right[], right[i] means the current index i the first right candle position.
        int[] right = new int[n];
        for (int i = n - 1, r = -1; i > -1; i--) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            right[i] = r;
        }

        // step 4: get the result.
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int left_candle = right[query[0]], right_candle = left[query[1]]; // left_candle also means the left candle boundary, right_candle means the right candle boundary.
            res[i] = left_candle == -1 || right_candle == -1 || left_candle >= right_candle ? 0 : prefixSum[right_candle] - prefixSum[left_candle];
        }
        return res;
    }
}
