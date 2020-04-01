package LeetCode;

public class LeetCode1137 {
    public int tribonacci(int n) {
        if (n == 0 || n == 1) return n;
        if (n == 2) return 1;
        int[] cache = new int[n+1];
        cache[1] = 1;
        cache[2] = 1;
        for(int i=3; i<n+1; i++) {
            cache[i] = cache[i-1] + cache[i-2] + cache[i-3];
        }
        return cache[n];
    }
}
