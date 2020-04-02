package LeetCode;

import java.util.Set;
import java.util.HashSet;


// Solution 1: intuitive solution
public class LeetCode202_Sol1 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        while(n != 1) {
            int newNumber = getNewNumber(n);
            if (set.contains(newNumber)) {
                return false;
            } else {
                set.add(newNumber);
                n = newNumber;
            }
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
