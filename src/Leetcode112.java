public class Leetcode112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        if(root.left != null) {
            root.left.val += root.val;
            if(hasPathSum(root.left, targetSum)) {
                return true;
            }
        }

        if(root.right != null) {
            root.right.val += root.val;
            if(hasPathSum(root.right, targetSum)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Leetcode112 leetcode112 = new Leetcode112();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        System.out.println(leetcode112.hasPathSum(root, 3));
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
        }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}