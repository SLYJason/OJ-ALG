package LeetCode;

public class LeetCode509 {
    public int fib(int N) {
        if(N == 0 || N == 1) return N;
        int[] cache = new int[N+1];
        cache[0] = 0;
        cache[1] = 1;
        for(int i=2; i<N+1; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[N];
    }
}
