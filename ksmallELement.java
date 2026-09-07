import java.util.Stack;

import javax.swing.tree.TreeNode;

public class ksmallELement {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            k--;

            if (k == 0) {
                return root.val;
            }

            root = root.right;
        }
    }
}
