package LeetCode.LC_401_600.LC510;

public class Solution {
    public Node inorderSuccessor(Node node) {
        // successor is in the right child.
        if(node.right != null) {
            Node right = node.right;
            Node successor = right;
            while(right != null) {
                successor = right;
                right = right.left;
            }
            return successor;
        }
        // successor is in the parent.
        Node parent = node.parent;
        Node successor = null;
        while(parent != null) {
            if(parent.val > node.val) {
                successor = parent;
                return successor;
            }
            parent = parent.parent;
        }
        return successor;
    }
}
