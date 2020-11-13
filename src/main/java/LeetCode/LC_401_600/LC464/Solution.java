package LeetCode.LC_401_600.LC464;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/**
 * Solution: backtrack + memorization.
 */
public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger >= desiredTotal) return true; // base case 1: player 1 can make one pick to win.
        if((maxChoosableInteger+1) * maxChoosableInteger / 2 < desiredTotal) return false; // base case 2: all picks' sum is smaller than desiredTotal, no matter how to pick, player 1 always lose.
        return canIWin(maxChoosableInteger, desiredTotal, new int[maxChoosableInteger+1], new HashMap<>());
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal, int[] state, Map<String, Boolean> memo) {
        String key = Arrays.toString(state);
        if(memo.containsKey(key)) return memo.get(key);

        for(int num=1; num<=maxChoosableInteger; num++) {
            if(state[num] == 0) {
                state[num] = 1;
                if(desiredTotal - num <= 0 || !canIWin(maxChoosableInteger, desiredTotal - num, state, memo)) { // check whether this lead to a win, i.e. the other player lose.
                    memo.put(key, true);
                    state[num] = 0;
                    return true;
                }
                state[num] = 0;
            }
        }
        memo.put(key, false);
        return false;
    }
}
