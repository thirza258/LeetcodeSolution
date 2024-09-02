import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();    

        if (root == null) {
            return result;
        }

        queue.add(root);
        int i = 0;
        List<TreeNode> levelNodes = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelNodes.add(node);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            if (i == 0) {
                level.add(node.val);
            }

        }

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) {
        this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}