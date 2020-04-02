package LeetCode;

public class LeetCode202_Sol2 {
    // Solution 2: Floyd's Cycle-Finding Algorithm, advanced solution
    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = n;
        while(slowRunner != 1 && fastRunner != 1) {
            slowRunner = getNewNumber(slowRunner);
            fastRunner = getNewNumber(getNewNumber(fastRunner));
            if(slowRunner == fastRunner && slowRunner != 1) return false;
        }
        return true;
    }

    private int getNewNumber(int n) {
        int ans = 0;
        while(n != 0) {
            int re = n % 10;
            ans += re * re;
            n = n/10;
        }
        return ans;
    }
}
