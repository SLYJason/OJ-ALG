package LeetCode.LC_401_600.LC547;

/**
 * Solution 1: DFS.
 */
public class Solution_1 {
    public int findCircleNum(int[][] M) {
        if(M.length == 0) return 1;
        int N = M.length;
        boolean[] visited = new boolean[N];
        int res = 0;
        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                res++;
                dfs(i, N, M, visited);
            }
        }
        return res;
    }

    private void dfs(int i, int N, int[][] M, boolean visited[]) {
        if(visited[i]) return;
        visited[i] = true;
        for(int neighbor = 0; neighbor<N; neighbor++) {
            if(M[i][neighbor] == 1) {
                dfs(neighbor, N, M, visited);
            }
        }
    }
}
