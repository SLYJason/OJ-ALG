package LeetCode.LC_1401_1600.LC1472;

import java.util.List;
import java.util.ArrayList;

/**
 * Solution 2: using List.
 */
public class Solution_2 {
    class BrowserHistory {
        List<String> list;
        int index;
        public BrowserHistory(String homepage) {
            list = new ArrayList();
            list.add(homepage);
            index = 0;
        }

        public void visit(String url) {
            list.subList(index + 1, list.size()).clear(); // clear forward history.
            list.add(url);
            index++;
        }

        public String back(int steps) {
            index = index - steps < 0 ? 0 : index - steps;
            return list.get(index);
        }

        public String forward(int steps) {
            index = index + steps > list.size() - 1 ? list.size() - 1 : index + steps;
            return list.get(index);
        }
    }
}
