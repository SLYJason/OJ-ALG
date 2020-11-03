package LeetCode.LC_1_200.LC9;

import java.util.List;
import java.util.LinkedList;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public boolean isPalindrome(int x) {
        if(x == 0) return true;
        if(x < 0) return false;
        List<Integer> list = new LinkedList();
        while(x > 0) {
            int a = x % 10;
            x = x / 10;
            list.add(a);
        }
        for(int i=0, j=list.size()-1; i < j; i++, j--) {
            if(list.get(i) != list.get(j)) return false;
        }
        return true;
    }
}
