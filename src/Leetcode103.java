import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean leftToRight = true; 

        for (int level = queue.size(); level > 0; level = queue.size()) {
            List<Integer> currentLevel = new ArrayList<>();
            List<TreeNode> nodesThisLevel = new ArrayList<>();

        
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                nodesThisLevel.add(node);

                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

        
            for (int i = 0; i < nodesThisLevel.size(); i++) {
                TreeNode node = nodesThisLevel.get(i);
                if (leftToRight) {
                    currentLevel.add(node.val);
                } else {
                    currentLevel.add(0, node.val);
                }
            }

            result.add(currentLevel);
            leftToRight = !leftToRight; 
        }

        return result;
    }
}

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {

    }
    TreeNode(int val) { 
        this.val = val; 
        this.left = null;
        this.right = null;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}