package LeetCode.BackTrack;

import java.util.List;
import java.util.LinkedList;

public class LeetCode60 {
    public String getPermutation(int n, int k) {
        // build factorial lookup: factorial[i] = i!
        int[] factorial = new int[n];
        factorial[0] = 1;
        for(int i=1; i<n; i++) {
            factorial[i] = i * factorial[i-1];
        }
        // build a number list from 1 to n
        List<Integer> numbers = new LinkedList();
        for(int i=1; i<=n; i++) {
            numbers.add(i);
        }
        int index = 0;
        String res = "";
        k--; // zero based index
        for(int i=1; i<=n; i++) {
            index = k / factorial[n-i];
            res += numbers.get(index);
            // remove the number from the number list, since this number has been placed
            numbers.remove(index);
            k = k - index * factorial[n-i];
        }
        return res;
    }
}

