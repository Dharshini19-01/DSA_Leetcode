import javax.swing.tree.TreeNode;

public class recoverBST {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        findSwappedNodes(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void findSwappedNodes(TreeNode root) {
        if (root == null) {
            return;
        }
        findSwappedNodes(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        findSwappedNodes(root.right);
    }
}
