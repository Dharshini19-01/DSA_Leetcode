import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class pathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(root, targetSum, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(TreeNode node, int targetSum,
                           List<Integer> path,
                           List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        targetSum -= node.val;
        if (node.left == null && node.right == null && targetSum == 0) {
            result.add(new ArrayList<>(path));
        }
        backtrack(node.left, targetSum, path, result);
        backtrack(node.right, targetSum, path, result);
        path.remove(path.size() - 1);
    }
}
