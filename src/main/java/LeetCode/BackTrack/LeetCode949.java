package LeetCode.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class LeetCode949 {
    String res = ""; // the final result.
    int elapsed = Integer.MIN_VALUE; // record max valid permutation elapsed time.
    public String largestTimeFromDigits(int[] arr) {
        backtrack(new ArrayList(), arr);
        return res;
    }

    // Calculate all permutations of arr index, store them in the list.
    private void backtrack(List<Integer> list, int[] arr) {
        if(list.size() == 4) {
            String hh = arr[list.get(0)] + "" + arr[list.get(1)];
            String mm = arr[list.get(2)] + "" + arr[list.get(3)];
            int currElapsed = Integer.valueOf(hh) * 60 + Integer.valueOf(mm);
            if(hh.compareTo("24") < 0 && mm.compareTo("60") < 0 && currElapsed >= elapsed) {
                elapsed = currElapsed;
                res = hh + ":" + mm;
            }
            return;
        }

        for(int i=0; i<4; i++) {
            if(list.contains(i)) continue;
            list.add(i);
            backtrack(list, arr);
            list.remove(list.size()-1);
        }
    }
}
