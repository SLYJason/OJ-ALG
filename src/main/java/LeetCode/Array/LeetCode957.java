package LeetCode.Array;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/**
 * Solution: need to detect the loop.
 */
public class LeetCode957 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        List<String> cache = new LinkedList();
        cache.add(Arrays.toString(cells));
        int loopStart = 0, loopEnd = 0;
        for(int i=0; i<N; i++) {
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if(cache.contains(key)) {
                // find a loop.
                loopStart = cache.indexOf(key);
                loopEnd = cache.size()-1;
                N = (N - loopStart) % (loopEnd - loopStart + 1);
                for(int j=0; j<N+1; j++) {
                    cells = nextDay(cells);
                }
                return cells;
            } else {
                cells = next;
                cache.add(Arrays.toString(cells));
            }
        }
        return cells;
    }

    private int[] nextDay(int[] cells){
        int[] next = new int[cells.length];
        for(int i=1; i<cells.length-1; i++){
            next[i]= cells[i-1] == cells[i+1] ? 1 : 0;
        }
        next[0] = 0;
        next[cells.length-1] = 0;
        return next;
    }
}
