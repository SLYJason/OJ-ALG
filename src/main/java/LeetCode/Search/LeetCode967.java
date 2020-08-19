package LeetCode.Search;

import java.util.List;
import java.util.LinkedList;

public class LeetCode967 {
    public int[] numsSameConsecDiff(int N, int K) {
        if(N == 1) {
            return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        List<Integer> list = new LinkedList();
        for(int num=1; num<10; num++) {
            dfs(list, num, N-1, K);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(List<Integer> list, int num, int N, int K) {
        if(N == 0) {
            list.add(num);
            return;
        }
        int digit = num % 10;
        if(digit + K < 10) {
            dfs(list, num*10 + digit + K, N-1, K);
        }
        if(K != 0 && digit - K >= 0) {
            dfs(list, num*10 + digit - K, N-1, K);
        }
    }
}
