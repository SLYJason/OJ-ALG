package LeetCode.Math;

import java.util.List;
import java.util.ArrayList;

public class LeetCode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList(numRows);
        for(int i=0; i<numRows; i++) {
            int size = i+1;
            List list = new ArrayList(size);
            for(int j=0; j<size; j++) {
                if(j == 0 || j == size-1) {
                    list.add(1);
                } else {
                    int ele = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);
                    list.add(ele);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
