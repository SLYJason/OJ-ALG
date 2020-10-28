package LeetCode.LC_1401_1600.LC1472;

import java.util.ArrayDeque;

/**
 * Solution 1: using 2 stacks, intuitive thoughts.
 */
public class Solution_1 {
    class BrowserHistory {
        ArrayDeque<String> back;
        ArrayDeque<String> forward;
        String curPage;
        public BrowserHistory(String homepage) {
            back = new ArrayDeque();
            forward = new ArrayDeque();
            curPage = homepage;
        }

        public void visit(String url) {
            forward.clear();
            back.push(curPage);
            curPage = url;
        }

        public String back(int steps) {
            while(steps > 0 && !back.isEmpty()) {
                forward.push(curPage);
                curPage = back.pop();
                steps--;
            }
            return curPage;
        }

        public String forward(int steps) {
            while(steps > 0 && !forward.isEmpty()) {
                back.push(curPage);
                curPage = forward.pop();
                steps--;
            }
            return curPage;
        }
    }
}
