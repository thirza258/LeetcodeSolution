import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> level = new ArrayList<>();
        stack.push(root);
        level.add(1);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int depth = level.remove(level.size() - 1);

            if(result.size() < 1) {
                result.add(node.val);
            }

            if (node.left != null) {
                stack.push(node.left);
                level.add(depth + 1);
            }

            if (node.right != null) {
                stack.push(node.right);
                level.add(depth + 1);
            }
        }
    }



    public static void main(String[] args) {
        Leetcode199 leetcode199 = new Leetcode199();
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        System.out.println(leetcode199.rightSideView(root));
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