package LeetCode.LC_1_200.LC6;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        List<StringBuilder> zigzag = new ArrayList();
        for(int i=0; i<numRows; i++) zigzag.add(new StringBuilder());
        boolean goDown = true;
        int row = 0;
        for(char c : s.toCharArray()) {
            zigzag.get(row).append(c);
            row = goDown ? row + 1 : row - 1;
            if(row == -1 || row == numRows) {
                goDown = !goDown;
                row = row == -1 ? 1 : numRows - 2;
            }
        }
        //build the final result.
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : zigzag) {
            res.append(sb);
        }
        return res.toString();
    }
}
