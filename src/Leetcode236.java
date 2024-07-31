import java.util.ArrayList;
import java.util.List;

public class Leetcode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        List<TreeNode> left = new ArrayList<>();
        List<TreeNode> right = new ArrayList<>();

        if (!helper(root, p, left) || !helper(root, q, right)) {
            return null;
        }

        int len = Math.min(left.size(), right.size());
        TreeNode result = root;
        for (int i = 0; i < len; i++) {
            if (left.get(i) != right.get(i)) {
                return left.get(i - 1);
            }
            result = left.get(i);
        }

        return result;

    }

    private boolean helper(TreeNode root, TreeNode p, List<TreeNode> list) {
        if (root == null) {
            return false;
        }

       if (root == p) {
        list.add(root);
        return true;
       }

         list.add(root);
         if(helper(root.left, p, list) || helper(root.right, p, list)) {
             return true;
         }
        list.remove(list.size() - 1);

        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}