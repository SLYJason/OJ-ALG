package LeetCode.Design;

import java.util.Stack;

public class LeetCode901 {
    class StockSpanner {
        // <price, result> pair
        Stack<int[]> stack;
        public StockSpanner() {
            stack = new Stack();
        }

        public int next(int price) {
            int res = 1;
            while(!stack.isEmpty() && stack.peek()[0] <= price) {
                res += stack.pop()[1];
            }
            stack.push(new int[]{price, res});
            return res;
        }
    }
}

