package LeetCode.BackTrack;

import java.util.List;
import java.util.LinkedList;

public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList();
        backtrack(res, new LinkedList(), n, k, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int n, int k, int start) {
        if(tempList.size() == k) {
            res.add(new LinkedList(tempList));
            return;
        }
        for(int i=start; i<=n; i++) {
            tempList.add(i);
            backtrack(res, tempList, n, k, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
