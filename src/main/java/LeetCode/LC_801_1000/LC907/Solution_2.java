package LeetCode.LC_801_1000.LC907;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution 2: monotonic stack.
 */
public class Solution_2 {
    public static int sumSubarrayMins(int[] arr) {
        int mod = 1_000_000_007, n = arr.length;

        // step 1: initialize previous less
        Deque<Integer> prevLess = new ArrayDeque<>();
        int[] prevDistance = new int[n]; // the distance between arr[i] and it's previous less element.
        for (int i = 0; i < n; i++) prevDistance[i] = i + 1; // initialize the distance.

        // step 2: initialize next less
        Deque<Integer> nextLess = new ArrayDeque<>();
        int[] nextDistance = new int[n]; // the distance between arr[i] and it's next less element.
        for (int i = n - 1; i >= 0; i--) nextDistance[i] = n - i; // initialize the distance.

        // step 3: monotonic stack
        for (int i = 0; i < n; i++) {
            // previous less element.
            while (!prevLess.isEmpty() && arr[i] < arr[prevLess.peek()]) {
                prevLess.pop();
            }
            prevDistance[i] = prevLess.isEmpty() ? i + 1 : i - prevLess.peek();
            prevLess.push(i);

            // next less element.
            while (!nextLess.isEmpty() && arr[i] < arr[nextLess.peek()]) {
                int index = nextLess.pop();
                nextDistance[index] = i - index;
            }
            nextLess.push(i);
        }

        // step 4: calculate the result, sum += arr[i] * prevDistance[i] * nextDistance[i].
        int sum = 0;
        for (int i = 0; i < n; i++) {
            long ans = (arr[i] * (long)prevDistance[i] * (long)nextDistance[i]) % mod;
            sum = (sum + (int)ans) % mod;
        }
        return sum;
    }
}
