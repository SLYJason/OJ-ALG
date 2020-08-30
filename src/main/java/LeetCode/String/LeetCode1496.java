package LeetCode.String;

import java.util.Set;
import java.util.HashSet;

public class LeetCode1496 {
    public boolean isPathCrossing(String path) {
        Set<String> seen = new HashSet();
        seen.add("[0,0]");
        int x = 0, y = 0;
        for(char ch : path.toCharArray()) {
            if(ch == 'N') y++;
            if(ch == 'S') y--;
            if(ch == 'E') x++;
            if(ch == 'W') x--;
            String curr = "[" + x + "," + y + "]";
            if(seen.contains(curr)) return true;
            seen.add(curr);
        }
        return false;
    }
}
