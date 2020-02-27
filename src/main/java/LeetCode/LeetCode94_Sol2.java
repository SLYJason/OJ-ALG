package LeetCode;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

// iterative solution
public class LeetCode94_Sol2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack();
        while(curr != null || !stack.isEmpty()) {
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            ans.add(curr.val);
            curr = curr.right;
        }
        return ans;
    }
}
