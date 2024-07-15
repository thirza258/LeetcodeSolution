import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode114 {
    public void flatten(TreeNode root) {
        if (root == null) return;

        List<TreeNode> v = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            v.add(node);

            if (node != null && node.right != null) {
                stack.push(node.right);
            }
            if (node != null && node.left != null) {
                stack.push(node.left);
            }
        }

        v.add(null); // Add null at the end
        for (int i = 0; i < v.size() - 1; i++) {
            if (v.get(i) != null) {
                v.get(i).left = null;
                v.get(i).right = v.get(i + 1);
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}